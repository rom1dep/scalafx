/*
 * Copyright (c) 2011-2015, ScalaFX Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the ScalaFX Project nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE SCALAFX PROJECT OR ITS CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package scalafx.scene

import javafx.beans.{binding => jfxbb, property => jfxbp}
import javafx.scene.{input => jfxsi, paint => jfxsp}
import javafx.{event => jfxe, geometry => jfxg, scene => jfxs}

import scala.language.implicitConversions
import scalafx.beans.property.ReadOnlyObjectProperty
import scalafx.delegate.SFXDelegate
import javafx.collections.ObservableList
import javafx.stage.Window

@deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10")
object SceneProperty {
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  implicit def sfxSceneProperty2jfx(p: SceneProperty): jfxbp.ReadOnlyObjectProperty[jfxs.Scene] = if (p != null) p.delegate else null
}

// This particular construct enables the reading of properties of the scene that will be set into the property later on.
@deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
class SceneProperty(override val delegate: jfxbp.ReadOnlyObjectProperty[jfxs.Scene]) extends ReadOnlyObjectProperty[jfxs.Scene](delegate) with SFXDelegate[jfxbp.ReadOnlyObjectProperty[jfxs.Scene]] {
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def camera: jfxbb.ObjectBinding[jfxbb.ObjectBinding[jfxs.Camera]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[jfxs.Camera]](delegate, "camera")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def cursor: jfxbb.ObjectBinding[jfxbb.ObjectBinding[jfxs.Cursor]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[jfxs.Cursor]](delegate, "cursor")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def depthBuffer: jfxbb.BooleanBinding = jfxbb.Bindings.selectBoolean(delegate, "depthBuffer")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def effectiveNodeOrientation: jfxbb.ObjectBinding[jfxbp.ReadOnlyObjectProperty[jfxg.NodeOrientation]] = jfxbb.Bindings.select[jfxbp.ReadOnlyObjectProperty[jfxg.NodeOrientation]](delegate, "effectiveNodeOrientation")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def eventDispatcher: jfxbb.ObjectBinding[jfxbb.ObjectBinding[jfxe.EventDispatcher]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[jfxe.EventDispatcher]](delegate, "eventDispatcher")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def fill: jfxbb.ObjectBinding[jfxbb.ObjectBinding[jfxsp.Paint]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[jfxsp.Paint]](delegate, "fill")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def focusOwner: jfxbb.ObjectBinding[jfxs.Node] = jfxbb.Bindings.select[jfxs.Node](delegate, "focusOwner")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def height: jfxbb.DoubleBinding = jfxbb.Bindings.selectDouble(delegate, "height")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def nodeOrientation: jfxbb.ObjectBinding[jfxbp.ReadOnlyObjectProperty[jfxg.NodeOrientation]] = jfxbb.Bindings.select[jfxbp.ReadOnlyObjectProperty[jfxg.NodeOrientation]](delegate, "nodeOrientation")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onContextMenuRequested: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.ContextMenuEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.ContextMenuEvent]](delegate, "onContextMenuRequested")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onDragDetected: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.DragEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.DragEvent]](delegate, "onDragDetected")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onDragDone: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.DragEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.DragEvent]](delegate, "onDragDone")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onDragDropped: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.DragEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.DragEvent]](delegate, "onDragDropped")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onDragEntered: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.DragEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.DragEvent]](delegate, "onDragEntered")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onDragExited: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.DragEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.DragEvent]](delegate, "onDragExited")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onDragOver: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.DragEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.DragEvent]](delegate, "onDragOver")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onInputMethodTextChanged: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.InputEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.InputEvent]](delegate, "onInputMethodTextChanged")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onKeyPressed: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.KeyEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.KeyEvent]](delegate, "onKeyPressed")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onKeyReleased: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.KeyEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.KeyEvent]](delegate, "onKeyReleased")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onKeyTyped: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.KeyEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.KeyEvent]](delegate, "onKeyTyped")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onMouseClicked: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]](delegate, "onMouseClicked")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10")
  def onMouseDragEntered: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.MouseDragEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseDragEvent]](delegate, "onMouseDragEntered")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10")
  def onMouseDragExited: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.MouseDragEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseDragEvent]](delegate, "onMouseDragExited")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10")
  def onMouseDragOver: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.MouseDragEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseDragEvent]](delegate, "onMouseDragOver")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10")
  def onMouseDragReleased: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.MouseDragEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseDragEvent]](delegate, "onMouseDragReleased")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onMouseDragged: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]](delegate, "onMouseDragged")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onMouseEntered: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]](delegate, "onMouseEntered")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onMouseExited: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]](delegate, "onMouseExited")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onMouseMoved: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]](delegate, "onMouseMoved")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onMousePressed: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]](delegate, "onMousePressed")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onMouseReleased: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]](delegate, "onMouseReleased")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onRotate: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.RotateEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.RotateEvent]](delegate, "onRotate")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onRotationFinished: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.RotateEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.RotateEvent]](delegate, "onRotationFinished")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onRotationStarted: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.RotateEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.RotateEvent]](delegate, "onRotationStarted")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onScroll: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.ScrollEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.ScrollEvent]](delegate, "onScroll")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onScrollFinished: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.ScrollEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.ScrollEvent]](delegate, "onScrollFinished")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onScrollStarted: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.ScrollEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.ScrollEvent]](delegate, "onScrollStarted")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onSwipeDown: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.SwipeEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.SwipeEvent]](delegate, "onSwipeDown")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onSwipeLeft: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.SwipeEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.SwipeEvent]](delegate, "onSwipeLeft")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onSwipeRight: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.SwipeEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.SwipeEvent]](delegate, "onSwipeRight")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onSwipeUp: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.SwipeEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.SwipeEvent]](delegate, "onSwipeUp")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onTouchMoved: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.TouchEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.TouchEvent]](delegate, "onTouchMoved")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onTouchPressed: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.TouchEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.TouchEvent]](delegate, "onTouchPressed")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onTouchReleased: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.TouchEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.TouchEvent]](delegate, "onTouchReleased")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onTouchStationary: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.TouchEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.TouchEvent]](delegate, "onTouchStationary")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onZoom: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.ZoomEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.ZoomEvent]](delegate, "onZoom")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onZoomFinished: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.ZoomEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.ZoomEvent]](delegate, "onZoomFinished")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def onZoomStarted: jfxbb.ObjectBinding[jfxbb.ObjectBinding[_ >: jfxsi.ZoomEvent]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.ZoomEvent]](delegate, "onZoomStarted")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def root: jfxbb.ObjectBinding[jfxs.Parent] = jfxbb.Bindings.select[jfxs.Parent](delegate, "root")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def stylesheets: jfxbb.ObjectBinding[jfxbb.ObjectBinding[ObservableList[String]]] = jfxbb.Bindings.select[jfxbb.ObjectBinding[javafx.collections.ObservableList[String]]](delegate, "stylesheets")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def userAgentStylesheet: jfxbb.ObjectBinding[String] = jfxbb.Bindings.select[String](delegate, "userAgentStylesheet")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def width: jfxbb.DoubleBinding = jfxbb.Bindings.selectDouble(delegate, "width")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def window: jfxbb.ObjectBinding[Window] = jfxbb.Bindings.select[javafx.stage.Window](delegate, "window")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def x: jfxbb.DoubleBinding = jfxbb.Bindings.selectDouble(delegate, "x")
  @deprecated("Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)", "8.0.60-R10") 
  def y: jfxbb.DoubleBinding = jfxbb.Bindings.selectDouble(delegate, "y")
}
