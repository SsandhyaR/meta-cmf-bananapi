include ccsp_common_bananapi.inc
RDEPENDS_${PN} += "ndisc6"
INSANE_SKIP:${PN} += "file-rdeps"
