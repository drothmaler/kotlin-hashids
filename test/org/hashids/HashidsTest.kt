package org.hashids

import org.junit.*;
import org.junit.Assert.*;

/**
 * Unit test for the Hashid library, based on the examples taken from the hashids.js README.md.
 *
 * @author Daniel Rothmaler <drothmaler@gmail.com>
 * @license MIT
 */
public class HashidTests() {
 Test fun encodingOneNumber() {
  val hashids = Hashids("this is my salt")

  var id = hashids.encode(12345)
  assertEquals("NkK9", id)
 }

 Test fun Decoding() {
  val hashids = Hashids("this is my salt")

  val numbers: LongArray = hashids.decode("NkK9");
  assertArrayEquals(longArray(12345L), numbers)
 }

 Test fun DecodingWithDifferentSalt() {
  val hashids = Hashids("this is my pepper")

  val numbers: LongArray = hashids.decode("NkK9")
  assertArrayEquals(longArray(), numbers)
 }

 Test fun DecodingSeveralNumbers() {
  val hashids = Hashids("this is my salt")

  val id = hashids.encode(683, 94108, 123, 5)
  assertEquals("aBMswoO2UB3Sj", id)
 }

 Test fun EncodingAndSpecifyingMinimumIdLength() {
  val hashids = Hashids("this is my salt", 8)

  val id = hashids.encode(1)
  assertEquals("gB0NV05e", id)
 }

 Test fun DecodingAndSpecifyingMinimumIdLength() {
  val hashids = Hashids("this is my salt", 8)

  val numbers = hashids.decode("gB0NV05e")
  assertArrayEquals(longArray(1), numbers)
 }

 Test fun SpecifyingCustomIdAlphabet() {
  val hashids = Hashids("this is my salt", 0, "0123456789abcdef")

  var id = hashids.encode(1234567)
  assertEquals("b332db5", id)
 }

 Test fun RepeatingNumbers() {
  val hashids = Hashids("this is my salt")

  var id = hashids.encode(5,5,5,5)
  assertEquals("1Wc8cwcE", id)
 }

 Test fun IncrementedNumbers() {
  val hashids = Hashids("this is my salt")

  var id = hashids.encode(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  assertEquals("kRHnurhptKcjIDTWC3sx", id)
 }

 Test fun IncrementingNumberIds() {
  val hashids = Hashids("this is my salt")

  assertEquals("NV", hashids.encode(1))
  assertEquals("6m", hashids.encode(2))
  assertEquals("yD", hashids.encode(3))
  assertEquals("2l", hashids.encode(4))
  assertEquals("rD", hashids.encode(5))
 }
}