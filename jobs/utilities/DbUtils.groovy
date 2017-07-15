package utilities

class DbUtils {

    static logRotator(job) {
        job.with {
            logRotator {
                daysToKeep(15)
                numToKeep(2)
            }
        }
    }

    static defaultWrappers(job) {
        job.with {
            wrappers {
                colorizeOutput()
                preBuildCleanup()
            }
        }
    }
}