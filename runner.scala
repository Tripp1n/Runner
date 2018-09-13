object Runner {

  var isRunning = true
  var score = 0
  var ground = collection.mutable.Buffer(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)

  val person0 = Vector(
     " O ",
     "/|v",
     """/ \"""
   )

   val person1 = Vector(
      " O ",
      " L ",
      " | "
    )

  def main(args: Array[String]) {
    // Game Loop
    while(isRunning) {
      printPerson(person0)
      generateGround
      renderGround
      Thread.sleep(250)
    }
  }

  def printPerson(person: Vector[String]) = {
    println("\033[H\033[2J")
    person.foreach{i => println(i)}
  }

  def generateGround = {
    ground.remove(0)
    if (willHoleSpawn) {
      ground.+=(0)
    } else {
      ground.+=(1)
    }
  }

  def renderGround = {
    for (i <- 0 until ground.length) {
      if (ground(i) == 1) print("----") else print("    ")
    }
  }

  def willHoleSpawn: Boolean = {
    0 == (math.random * 50).toInt - score
  }
}
