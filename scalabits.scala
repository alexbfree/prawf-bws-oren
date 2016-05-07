
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
