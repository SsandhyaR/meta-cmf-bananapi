include ccsp_common_bananapi.inc
SRC_URI:remove = "file://filogic-factoryReset.patch"

INSANE_SKIP:${PN} += "dev-so"

