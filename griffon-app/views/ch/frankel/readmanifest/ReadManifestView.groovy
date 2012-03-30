/*
* Copyright 2011 Nicolas Frankel
*
* Licensed under the Apache License, Version 2.0 (the "License"); you may not
* use this file except in compliance with the License. You may obtain a copy of
* the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
* WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
* License for the specific language governing permissions and limitations under
* the License.
*/
package ch.frankel.readmanifest

import java.awt.GridBagConstraints

import ca.odell.glazedlists.gui.TableFormat
import ca.odell.glazedlists.swing.EventTableModel

class JarFile {

  String name
  String version
}

def insets = [4, 4, 4, 4]

application(title: 'Read Manifest',
    preferredSize: [640, 480],
    pack: true,
    locationByPlatform:true,
    iconImage: imageIcon('/griffon-icon-48x48.png').image,
    iconImages: [
      imageIcon('/griffon-icon-48x48.png').image,
      imageIcon('/griffon-icon-32x32.png').image,
      imageIcon('/griffon-icon-16x16.png').image
    ]) {
      gridBagLayout()
      label('Root folder',
          constraints: gbc(insets: insets))
      textField(text: bind('folder',
          target: model,
          mutual: true,
          value: System.getProperty('user.home')),
          constraints: gbc(gridy: 0,
          weightx: 1.0,
          fill: GridBagConstraints.HORIZONTAL,
          insets: insets))
      button('Browse',
          constraints: gbc(
          gridy: 0,
          insets: insets))
      scrollPane(constraints: gbc(gridx: 0,
          gridwidth: 3,
          weightx: 1.0,
          weighty: 1.0,
          fill: GridBagConstraints.BOTH)) {
            table() {
              tableFormat = defaultTableFormat(columnNames: ['Name', 'Version'])
              eventTableModel(source: model.jarsList, format: tableFormat)
            }
          }
    }
