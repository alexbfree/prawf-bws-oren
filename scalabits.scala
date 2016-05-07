
// AVOID METHODS WITH SIDE EFFECTS

// DON'T USE VARS IF AVOIDABLE


def greet() = println("Hello, world!")
// returns Unit , ie void - executed for side effects

// imperative - bad
def printArgs(args: Array[String]): Unit = {
  var i = 0
  while (i < args.length) {
    println(args(i))
    i += 1
  }
}


// functional - no vars - good
def printArgs(args: Array[String]): Unit = {
  args.foreach(println)
}


def formatArgs(args: Array[String]) = args.mkString("\n")

//count.toJson

//s"""
//  |{
//  |"message":$count
//  |}
//""".stripMargin

//if (collection.count().headResult())
//  collection.find().first().headResult().toJson
//else
//  None
//headResult().toJson


//val universe = reflect.runtime.universe
//import universe._
//val longZero : Long = 0
// if collection.count().headResult() == q"0L"

//import scala.util.Try
//count = Try { collection.count().headResult().toInt }.getOrElse(0)
