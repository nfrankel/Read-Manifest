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


class ReadManifestController {

  def model
  def view

  def list = {

    model.jarsList.clear()

    File dir = new File(model.folder)

    if (dir.isDirectory()) {

      def jars = []

      dir.listFiles( [getDescription: { -> '*.jar'}, accept: { file -> file ==~ /.*?\.jar/ }] as FileFilter ).each {

        String version

        String name = it.getName()

        int index = name.lastIndexOf('-')

        if (index > -1 && name.charAt(index + 1) ==~ /\d/) {

          version = name.substring(index + 1, name.size() - 4)
        }

        jars << [name: name, version: version]
      }

      model.jarsList.addAll(jars)
    }
  }
}
