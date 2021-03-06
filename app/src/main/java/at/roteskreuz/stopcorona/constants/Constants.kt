package at.roteskreuz.stopcorona.constants

import at.roteskreuz.stopcorona.BuildConfig
import at.roteskreuz.stopcorona.BuildConfig.APPLICATION_ID
import at.roteskreuz.stopcorona.skeleton.core.constants.BaseAppRequest
import com.google.android.gms.common.GoogleApiAvailability
import org.threeten.bp.Duration

/**
 * Constants for whole app scope.
 */
object Constants {

    /**
     * Constants useful for debugging.
     */
    object Debug {

        const val STRICT_MODE_ENABLED = false
    }

    /**
     * Constants for behavior tuning
     */
    object Behavior {

        /**
         * Minimum time between offline syncs in ms.
         */
        val OFFLINE_SYNC_INTERVAL: Duration = if (isDebug) {
            Duration.ofMinutes(5)
        } else {
            Duration.ofHours(1)
        }

        /**
         * Minimum delay between self retest notifications.
         */
        val SELF_RETEST_NOTIFICATION_INTERVAL: Duration = Duration.ofHours(6)

        /**
         * Time for how long the revoking is possible. After this time revoke button must be hidden.
         */
        val MEDICAL_CONFIRMATION_REVOKING_POSSIBLE_DURATION: Duration = Duration.ofHours(48)
    }

    /**
     * Constants related to the exposure notification framework.
     */
    object ExposureNotification {

        /**
         * 20.18.13.xx
         */
        const val MIN_SUPPORTED_GOOGLE_PLAY_APK_VERSION = 201813000

        const val GOOGLE_PLAY_SERVICES_PACKAGE_NAME = GoogleApiAvailability.GOOGLE_PLAY_SERVICES_PACKAGE

        /**
         * Framework expose new event each 10 minutes.
         */
        val INTERVAL_NUMBER_OFFSET: Duration = Duration.ofMinutes(10)

        /**
         * Local folder name for copy of exposure archives to be processed.
         */
        const val EXPOSURE_ARCHIVES_FOLDER = "exposure_archives"

        /**
         * In some cases the exposure notification framework will not send the expected
         * ACTION_EXPOSURE_STATE_UPDATED_BROADCAST.
         * After this time out we will just assume that the exposure state has been updated.
         */
        val ACTION_EXPOSURE_STATE_UPDATED_BROADCAST_TIMEOUT: Duration = if (isDebug) {
            Duration.ofMinutes(1)
        } else {
            Duration.ofMinutes(5)
        }
    }

    /**
     * Constants for shared preferences.
     */
    object Prefs {

        /**
         * Name of shared preferences file.
         */
        const val FILE_NAME = "prefs"
        private const val PREFIX = "pref_"

        const val ONBOARDING_REPOSITORY_PREFIX = PREFIX + "onboarding_repository_"
        const val INFECTION_MESSENGER_REPOSITORY_PREFIX = PREFIX + "infection_messenger_repository_"
        const val DATA_PRIVACY_REPOSITORY_PREFIX = PREFIX + "terms_and_conditions_repository_"
        const val DASHBOARD_PREFIX = PREFIX + "dashboard_"
        const val QUARANTINE_REPOSITORY_PREFIX = PREFIX + "quarantine_repository_"
        const val OFFLINE_SYNC_PREFIX = PREFIX + "offline_sync_"
        const val PREFERENCES_MIGRATION_MANAGER_PREFIX = PREFIX + "preferences_migration_manager_"
        const val CHANGELOG_MANAGER_PREFIX = PREFIX + "changelog_manager_"
        const val EXPOSURE_NOTIFICATION_MANAGER_PREFIX = PREFIX + "exposure_notification_manager_"
    }

    /**
     * Constants related to network interaction.
     */
    object API {

        const val HOSTNAME = BuildConfig.HOSTNAME
        const val BASE_URL = BuildConfig.BASE_URL

        const val HOSTNAME_TAN = BuildConfig.HOSTNAME_TAN
        const val BASE_URL_TAN = BuildConfig.BASE_URL_TAN

        const val HOSTNAME_CDN = BuildConfig.HOSTNAME_CDN
        const val BASE_URL_CDN = BuildConfig.BASE_URL_CDN

        val CERTIFICATE_CHAIN_DEFAULT: Array<String> = BuildConfig.CERTIFICATE_CHAIN
        val CERTIFICATE_CHAIN_TAN: Array<String> = BuildConfig.CERTIFICATE_CHAIN_TAN
        val CERTIFICATE_CHAIN_CDN: Array<String> = BuildConfig.CERTIFICATE_CHAIN_CDN

        object Header {
            const val AUTHORIZATION_KEY = "AuthorizationKey"
            const val AUTHORIZATION_VALUE = BuildConfig.AUTHORIZATION_VALUE
            const val APP_ID_KEY = "X-AppId"
            const val APP_ID_VALUE = APPLICATION_ID
        }
    }

    /**
     * Constants related to database.
     */
    object DB {

        const val FILE_NAME = "default.db"
    }

    /**
     * Request codes for fragment for result or any other identification which is required to be unique.
     * This ensures unique request codes for every screen, permission and whatever you need to be unique
     * across whole application.
     *
     * @see [BaseAppRequest].
     */
    object Request {

        private const val APP_BASE_REQUEST = BaseAppRequest.APP_BASE_REQUEST
        private const val OFFSET = BaseAppRequest.OFFSET

        const val REQUEST_DASHBOARD = APP_BASE_REQUEST + (1 shl OFFSET)
        const val REQUEST_REPORTING_STATUS_FRAGMENT = APP_BASE_REQUEST + (2 shl OFFSET)
    }

    /**
     * Ids of the notification channels the app is notifying through.
     */
    object NotificationChannels {

        const val CHANNEL_INFECTION_MESSAGE = "channel_infection_message"
        const val CHANNEL_SELF_RETEST = "channel_self_retest"
        const val CHANNEL_RECOVERED = "channel_recovered"
        const val CHANNEL_QUARANTINE = "channel_quarantine"
        const val CHANNEL_AUTOMATIC_DETECTION = "channel_automatic_detection"
        const val CHANNEL_UPLOAD_KEYS = "channel_upload_keys"
    }

    /**
     * Country codes for questionnaires.
     */
    object Questionnaire {

        const val COUNTRY_CODE_CZ = "cz"
        const val COUNTRY_CODE_DE = "de"
        const val COUNTRY_CODE_EN = "en"
        const val COUNTRY_CODE_FR = "fr"
        const val COUNTRY_CODE_HU = "hu"
        const val COUNTRY_CODE_SK = "sk"
    }

    /**
     * Other constants without some relation.
     */
    object Misc {

        const val EMPTY_STRING = ""
        const val SPACE = " "
    }
}