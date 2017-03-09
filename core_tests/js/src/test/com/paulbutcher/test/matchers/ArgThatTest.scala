// Copyright (c) 2011-2015 ScalaMock Contributors (https://github.com/paulbutcher/ScalaMock/graphs/contributors)
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.

package com.paulbutcher.test.matchers

import org.scalamock.scalatest.MockFactory
import org.scalatest.{ FlatSpec, Matchers }

class ArgThatTest extends FlatSpec with Matchers with MockFactory {

  behavior of "ArgThat"

  it should "check predicate while matching arguments" in {
    val startsWithPredicate = argThat[String](x => x.startsWith("A"))
    startsWithPredicate.equals("Alice") shouldBe true
    startsWithPredicate.equals("Anna") shouldBe true
    startsWithPredicate.equals("Bob") shouldBe false
    // todo: do we need to do anything with this?
    intercept[scala.scalajs.runtime.UndefinedBehaviorError] { startsWithPredicate.equals(55) } // 55 is not a String
  }
}
