package com.test

import com.test.App._
class AppTest extends org.scalatest.FunSuite {

  test("Valid Sudoku From File") {
    val source = scala.io.Source.fromFile(s"src/test/resources/validSudoku")
    assert(printResult(source) == "0(VALID)")
  }

  test("Invalid Sudoku From File") {
    val source = scala.io.Source.fromFile(s"src/test/resources/invalidSudoku")
    assert(printResult(source) == "1(INVALID)")
  }

  test("checkSudoku") {
    val list = scala.collection.mutable.ListBuffer[List[String]]()
    list += List("5", "3", "4", "6", "7", "8", "9", "1", "2")
    list += List("6", "7", "2", "1", "9", "5", "3", "4", "8")
    list += List("1", "9", "8", "3", "4", "2", "5", "6", "7")
    list += List("8", "5", "9", "7", "6", "1", "4", "2", "3")
    list += List("4", "2", "6", "8", "5", "3", "7", "9", "1")
    list += List("7", "1", "3", "9", "2", "4", "8", "5", "6")
    list += List("9", "6", "1", "5", "3", "7", "2", "8", "4")
    list += List("2", "8", "7", "4", "1", "9", "6", "3", "5")
    list += List("3", "4", "5", "2", "8", "6", "1", "7", "9")
    val result = checkSudoku(list.toList)
    assert(result)
  }

  test("failSudoku") {
    val list = scala.collection.mutable.ListBuffer[List[String]]()
    list += List("5", "3", "4", "6", "7", "8", "9", "9", "2")
    list += List("6", "7", "2", "1", "9", "5", "3", "4", "8")
    list += List("1", "9", "8", "3", "4", "2", "5", "6", "7")
    list += List("8", "5", "9", "7", "6", "1", "4", "2", "3")
    list += List("4", "2", "6", "8", "5", "3", "7", "9", "1")
    list += List("7", "1", "3", "9", "2", "4", "8", "5", "6")
    list += List("9", "6", "1", "5", "3", "7", "2", "8", "4")
    list += List("2", "8", "7", "4", "1", "9", "6", "3", "5")
    list += List("3", "4", "5", "2", "8", "6", "1", "3", "9")
    val result = checkSudoku(list.toList)
    assert(!result)

  }

}
