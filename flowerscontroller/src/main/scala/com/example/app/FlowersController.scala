package com.example.app

import org.scalatra._

// JSON-related libraries
import org.json4s.{DefaultFormats, Formats}

import org.scalatra.json._
import org.json4s.JsonAST._
import org.mongodb.scala._
import tour.Helpers._
import scala.util.Try

class FlowersController extends ScalatraServlet with JacksonJsonSupport {

  //val universe = reflect.runtime.universe
  //import universe._

  val mongoClient: MongoClient = MongoClient()
  val database: MongoDatabase = mongoClient.getDatabase("prawf-bws-oren")
  val collection: MongoCollection[Document] = database.getCollection("person");
  //val database: MongoDatabase = mongoClient.getDatabase("serengeti3")
  //val collection: MongoCollection[Document] = database.getCollection("serengeti_subjects");


  // Sets up automatic case class to JSON output serialization, required by
  // the JValueResult trait.
  protected implicit lazy val jsonFormats: Formats = DefaultFormats

  protected override def transformRequestBody(body: JValue): JValue = body.camelizeKeys
  protected override def transformResponseBody(body: JValue): JValue = body.underscoreKeys

  // Before every action runs, set the content type to be in JSON format.
  before() {
    contentType = formats("json")
  }

  get("/"){
    FlowerData.all
  }

  get("/mongo/first"){
    val count = Try { collection.count().headResult().toInt }.getOrElse(0)
    if (count == 0)
      s"""
        |{
        |"message":"No records available"
        |}
      """.stripMargin
    else
      collection.find().first().headResult().toJson
  }

  def toDocument(person:Person) : Document = {
    return Document("_id" -> person.id, "name" -> person.name)
  }

  post("/mongo/create") {
    val person = parsedBody.extract[Person]
    val document = toDocument(person)
    collection.insertOne(document).results()
  }

  post("/create") {
    parsedBody.extract[Person]
  }

  //def jsonizeDocs(cDocument: Seq[Document]): String = {
  //  val sb=new StringBuilder
  //  for (doc <- cDocument) {
  //    if (sb.nonEmpty) {
  //      sb.append(",")
  //    }
  //    sb.append(doc.toJson)
  //  }
  //  sb.toString
  //}

}

// A Flower object to use as a faked-out data model
case class Flower(slug: String, name: String)

object FlowerData {

  /**
    * Some fake flowers data so we can simulate retrievals.
    */
  var all = List(
    Flower("yellow-tulip", "Yellow Tulip"),
    Flower("red-rose", "Red Rose"),
    Flower("black-rose", "Black Rose"))
}

case class Person(id: Int, name: String)
