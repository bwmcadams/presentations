package com.mongodb.casbah
package test 

import com.mongodb.casbah.gridfs.Imports._

import java.security.MessageDigest
import java.io._

import org.specs._
import org.specs.specification.PendingUntilFixed

class GridFSSpec extends Specification with PendingUntilFixed {
  val logo_md5 = "479977b85391a88bbc1da1e9f5175239"
  val digest = MessageDigest.getInstance("MD5")


  "Casbah's GridFS Implementations" should {
    shareVariables()
    implicit val mongo = MongoConnection()("casbah_test")
    mongo.dropDatabase()
    val logo = new FileInputStream("casbah-gridfs/src/test/resources/powered_by_mongo.png")
    val gridfs = GridFS(mongo)

    "Correctly save a file to GridFS" in {
      gridfs must notBeNull 
      logo must notBeNull

      gridfs(logo) { fh =>
        fh.filename = "powered_by_mongo.png"
        fh.contentType = "image/png"
      }
    
    }

    "Find the file in GridFS later" in {
      val file = gridfs.findOne("powered_by_mongo.png")
      file must notBeNull
      file must haveSuperClass[GridFSDBFile]
      file.md5 must beEqualTo(logo_md5)
      println(file.md5)
    }

  }

}


// vim: set ts=2 sw=2 sts=2 et:
