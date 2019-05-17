import scala.io.Source
import java.io.{FileNotFoundException, IOException}
import scala.collection.mutable.LinkedList
import scala.collection.immutable.ListMap

object Main extends App {

  val fileName = "/src/main/scala/arizona-diamondbacks.yaml"
  try {

    val text = scala.io.Source.fromFile(fileName)
      .getLines
      .flatMap(_.split("\\W+"))
      .foldLeft(Map.empty[String, Int]) {
        (count, key) => count + (key -> (count.getOrElse(key, 0) + 1))
      }

    //println(text)

    //val lowerCaseText = text.foreach(i => key = key.toLowerCase)

    //println(lowerCaseText)

    // https://alvinalexander.com/scala/how-to-sort-map-in-scala-key-value-sortby-sortwith
    val sortedText = ListMap(text.toSeq.sortWith(_._2 > _._2): _*)

    println(sortedText)

  } catch {
    case e: FileNotFoundException => println("Couldn't find that file.")
    case e: IOException           => println("Got an IOException!")
  }

}
