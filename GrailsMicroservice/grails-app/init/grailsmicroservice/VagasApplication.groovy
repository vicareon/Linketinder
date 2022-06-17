package grailsmicroservice

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration

import groovy.transform.CompileStatic

@CompileStatic
class VagasApplication extends GrailsAutoConfiguration {
    static void main(String[] args) {
        GrailsApp.run(VagasApplication, args)
    }
}