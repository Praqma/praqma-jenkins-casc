job('XYZ_release')
job('Retention_qw')

listView("Retention") {
    jobs {
        name('Retention_qw')
    }
    columns {
        status()
        weather()
        name()
        lastSuccess()
        lastFailure()
        lastDuration()
      }
}