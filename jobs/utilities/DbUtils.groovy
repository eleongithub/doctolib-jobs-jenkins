package utilities

class DbUtils {

    static defaultLogRotatorPolicy(job) {
        job.with {
            logRotator {
                daysToKeep(15)
                numToKeep(2)
            }
        }
    }

    static defaultWrappersPolicy(job) {
        job.with {
            wrappers {
                colorizeOutput()
                preBuildCleanup()
            }
        }
    }
}
