> db.inventory.update(
 {
 "title": "The Hitchhiker's Guide to the Galaxy: The Greatest Book Ever Written"
 },
 {
  $set: {"title": "The Hitchhiker's Guide to the Galaxy", "genre": "Humor"},
  $inc: {"qty": 50}
 })
> db.inventory.findOne({"title": "The Hitchhiker's Guide to the Galaxy"})
{
  "_id" : ObjectId("4c868434cad498145f000001"),
  "author" : "Douglas Adams",
  "genre" : "Humor",
  "isbn" : "0345391803",
  "publicationYear" : 1995,
  "publisher" : "The Ballantine Publishing Group",
  "price": {
    "msrp": 15.00,
    "discount": 10.00
  },
  "qty" : 150,
  "title" : "The Hitchhiker's Guide to the Galaxy",
  "tags": [
    {"tag": "science fiction", "weight": .75},
    {"tag": "comedy", "weight": .75},
    {"tag": "humor", "weight": .75},
    {"tag": "snarky", "weight": .70},
    {"tag": "towels", "weight": .5}
  ]
}
