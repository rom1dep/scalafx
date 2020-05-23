/*
 * Copyright (c) 2011-2019, ScalaFX Project
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

package scalafx.controls

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.controls.controls.{PropertiesNodes, _}
import scalafx.geometry.{Orientation, Pos}
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.layout.{BorderPane, FlowPane, Priority, VBox}
import scalafx.scene.paint.Color
import scalafx.util.converter.DoubleStringConverter
import javafx.geometry

object SliderTest extends JFXApp {

  val slider: Slider = new Slider {
    alignmentInParent = Pos.Center
  }

  val controlsPane: VBox = new VBox {
    spacing = 5
    fillWidth = true
    alignment = Pos.Center
    hgrow = Priority.Never
    children = List(new SliderControls(slider), new ControlControls(slider))
  }

  val mainPane: BorderPane = new BorderPane {
    top = new FlowPane {
      children = List(slider)
    }
    center = controlsPane
    vgrow = Priority.Always
    hgrow = Priority.Always
  }

  stage = new PrimaryStage {
    title = "Slider Test"
    width = 300
    height = 380
    scene = new Scene {
      fill = Color.LightGray
      content = mainPane
    }
  }

}

class SliderControls(target: Slider) extends PropertiesNodes[Slider](target, "Slider Properties") {

  override protected def resetProperties(): Unit = {
    target.value = originalValue
    target.blockIncrement = originalBlockIncrement
    txfLabelFormatter.text = null
    target.majorTickUnit = originalMajorTickUnit
    target.max = originalMax
    target.min = originalMin
    target.minorTickCount = originalMinorTickCount
    target.showTickLabels = originalShowTickLabels
    target.showTickMarks = originalShowTickMarks
    target.snapToTicks = originalSnapToTicks
    target.valueChanging = originalValueChanging
    target.orientation = originalOrientation
  }

  val originalValue = target.value.get
  val txfValue = new TextField
  target.value.onChange(txfValue.text = target.value.get.toString)
  txfValue.onAction = handle {super.fillDoublePropertyFromText(target.value, txfValue, false)}

  val originalBlockIncrement = target.blockIncrement.get
  val txfBlockIncrement: TextField = new TextField {
    text = originalBlockIncrement.get.toString
  }
  target.blockIncrement.onChange(txfBlockIncrement.text = target.blockIncrement.get.toString)
  txfBlockIncrement.onAction = handle {fillDoublePropertyFromText(target.blockIncrement, txfBlockIncrement, false)}

  val txfLabelFormatter = new TextField
  txfLabelFormatter.text.onChange(
    if (txfLabelFormatter.text.get.isEmpty) {
      target.labelFormatter = null
    } else {
      target.labelFormatter = new DoubleStringConverter
    })

  val originalMajorTickUnit: Double = target.majorTickUnit.get()
  val txfMajorTickUnit: TextField = new TextField {
    text = originalMajorTickUnit.toString
  }
  target.majorTickUnit.onChange(txfMajorTickUnit.text = target.majorTickUnit.get.toString)
  txfMajorTickUnit.onAction = handle {fillDoublePropertyFromText(target.majorTickUnit, txfMajorTickUnit, false)}

  val originalMax: Double = target.max.get()
  val txfMax: TextField = new TextField {
    text = originalMax.toString
  }
  target.max.onChange(txfMax.text = target.max.get.toString)
  txfMax.onAction = handle {fillDoublePropertyFromText(target.max, txfMax, false)}

  val originalMinorTickCount: Int = target.minorTickCount.get()
  val txfMinorTickCount: TextField = new TextField {
    text = originalMinorTickCount.toString
  }
  target.minorTickCount.onChange(txfMinorTickCount.text = target.minorTickCount.get.toString)
  txfMinorTickCount.onAction = handle {fillIntPropertyFromText(target.minorTickCount, txfMinorTickCount, false)}

  val originalMin: Double = target.min.get()
  val txfMin: TextField = new TextField {
    text = originalMin.toString
  }
  target.min.onChange(txfMin.text = target.min.get.toString)
  txfMin.onAction = handle {fillDoublePropertyFromText(target.min, txfMin, false)}

  val originalShowTickLabels = target.showTickLabels.get
  val chbShowTickLabels: CheckBox = new CheckBox {
    selected <==> target.showTickLabels
  }

  val originalShowTickMarks = target.showTickMarks.get
  val chbShowTickMarks: CheckBox = new CheckBox {
    selected <==> target.showTickMarks
  }

  val originalSnapToTicks: Boolean = target.snapToTicks.get()
  val chbSnapToTicks: CheckBox = new CheckBox {
    selected <==> target.snapToTicks
  }

  val originalValueChanging: Boolean = target.valueChanging.get()
  val chbValueChanging: CheckBox = new CheckBox {
    selected <==> target.valueChanging
  }

  val originalOrientation: geometry.Orientation = target.orientation.get()
  val tggOrientation = new ToggleGroup
  val rdbHorizontal: RadioButton = new RadioButton {
    text = Orientation.Horizontal.toString
    toggleGroup = tggOrientation
  }
  val rdbVertical: RadioButton = new RadioButton {
    text = Orientation.Vertical.toString
    toggleGroup = tggOrientation
  }
  rdbHorizontal.selected = (target.orientation.get() == Orientation.Horizontal)
  target.orientation.onChange(rdbHorizontal.selected = (target.orientation.get() == Orientation.Horizontal))
  tggOrientation.selectedToggle.onChange {
    target.orientation = if (rdbHorizontal.selected.get) Orientation.Horizontal else Orientation.Vertical
  }

  super.addNode("Value", txfValue)
  super.addNode("Block Increment", txfBlockIncrement)
  super.addNode("Pattern Formatter", txfLabelFormatter)
  super.addNode("Min", txfMin)
  super.addNode("Max", txfMax)
  super.addNode("Minor Tick Count ", txfMinorTickCount)
  super.addNode("Major Tick Unit", txfMajorTickUnit)
  super.addNode("Show Tick Labels", chbShowTickLabels)
  super.addNode("Show Tick Marks", chbShowTickMarks)
  super.addNode("Snap To Ticks", chbSnapToTicks)
  super.addNode("Value Changing", chbValueChanging)
  super.addNode("Orientation", new VBox {
    children = List(rdbHorizontal, rdbVertical)
  })

  super.addNode(btnReset)

}
