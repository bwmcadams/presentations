#!/bin/sh

echo "*** Verifying existence of 4 volumes /dev/sdf, /dev/sdg, /dev/sdh and /dev/sdi"
if [ -b "/dev/sdf" -a -b "/dev/sdg" -a -b "/dev/sdh" -a -b "/dev/sdi" ]; then
    echo "# Found expected block devices."
else
    echo "!!! Did not find expected block devices.  Error."
    exit -1
fi
until read -p "??? - How big (in GB) are the disks (They should be the same size)?  " disk_size && [[ $disk_size ]]; do
    echo "Please enter a disk size."
done 

lv_size=$(echo "scale=2; $disk_size * 2.0" | bc)
echo "*** Assuming a per disk size of $disk_size gigs, will create a logical volume of $lv_size gigs, with $lv_size reserved for snapshots"

echo "*** Partitioning disks..."

echo "~ Partitioning /dev/sdf"
echo ',,L' | sfdisk /dev/sdf
echo "~ Partitioning /dev/sdg"
echo ',,L' | sfdisk /dev/sdg
echo "~ Partitioning /dev/sdh"
echo ',,L' | sfdisk /dev/sdh
echo "~ Partitioning /dev/sdi"
echo ',,L' | sfdisk /dev/sdi

sleep 6
echo "*** Creating /dev/md0 as a RAID 10"

/sbin/mdadm /dev/md0 --create --level=10 --raid-devices=4 /dev/sdf1 /dev/sdg1 /dev/sdh1 /dev/sdi1 

echo " ~ Allocating /dev/md0 as a physical volume."

/sbin/pvcreate /dev/md0

echo " ~ Allocating a Volume Group 'mongodb_vg'"

/sbin/vgcreate -s 64M mongodb_vg /dev/md0

echo " ~ Creating a Logical Volume 'mongodb_lv'"

num_extents=$(echo "$disk_size * 1000 / 64" | bc)

/sbin/lvcreate -l $num_extents -nmongodb_lv mongodb_vg

echo " ~ Formatting the new volume (/dev/mongodb_vg/mongodb_lv) with EXT4"

/sbin/mkfs.ext4 /dev/mongodb_vg/mongodb_lv

echo " ~ Done! Go ahead and mount the new filesystem.  Suggested FStab: "
echo " /dev/mongodb_vg/mongodb_files_lv /data ext4 defaults,noatime 0 0"

