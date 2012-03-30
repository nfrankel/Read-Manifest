application {
  title = 'ReadManifest'
  startupGroups = ['readManifest']
  autoShutdown = true
}

mvcGroups {
  'readManifest' {
    model      = 'ch.frankel.readmanifest.ReadManifestModel'
    view       = 'ch.frankel.readmanifest.ReadManifestView'
    controller = 'ch.frankel.readmanifest.ReadManifestController'
  }
}
