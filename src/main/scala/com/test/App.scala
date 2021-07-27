package com.test

import scala.io.Source
object App {
  def main(args: Array[String]): Unit = {
    require(args.length > 0, "File path can not be empty")
    val source = Source.fromFile(args.head)
    print(printResult(source))
  }

  def printResult(source: Source): String = {
    val inputList = scala.collection.mutable.ListBuffer[List[String]]()
    for (line <- source.getLines())
      inputList += line.split(",", -1).map(_.trim).toList
    source.close()
    require(inputList.length == 9, "Board length is not equal to 9")
    if (checkSudoku(inputList.toList)) 0 + "(VALID)"
    else 1 + "(INVALID)"
  }

  def checkSudoku(inputBoard: List[List[String]]): Boolean = {
    val length = inputBoard.length
    for (i <- 0 until length) {
      val rows = scala.collection.mutable.Set[String]()
      val columns = scala.collection.mutable.Set[String]()
      val blocks = scala.collection.mutable.Set[String]()
      val row = 3 * (i / 3)
      val column = 3 * (i % 3)
      for (j <- 0 until length) {
        if (inputBoard(i)(j) != "" && !rows.add(inputBoard(i)(j))) return false
        if (inputBoard(j)(i) != "" && !columns.add(inputBoard(j)(i)))
          return false
        if (inputBoard(row + j / 3)(column + j % 3) != "" && !blocks.add(
              inputBoard(row + j / 3)(column + j % 3)
            )) return false
      }
    }
    true
  }

}
