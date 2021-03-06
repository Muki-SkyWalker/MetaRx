package pl.metastack.metarx.reactive.stream

import pl.metastack.metarx.DeltaDict

trait MapExtended[Container[_], T] {
  /**
   * Applies partial function `f` on each element; if the function is not
   * defined for the current input, it is filtered out
   */
  def collect[U](f: PartialFunction[T, U]): Container[U]

  /**
   * Applies `f` on each element and flatten its result into the stream
   */
  def flatMap[U](f: T => Container[U]): Container[U]

  /**
   * @see flatMap
   */
  def flatMapSeq[U](f: T => Seq[U]): Container[U]

  /**
   * Map `f` on each element and turn stream into a dictionary
   */
  def mapTo[U](f: T => U): DeltaDict[T, U]
}
