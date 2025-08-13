DESCRIPTION = "Inclusion of prebuild bl2.img and fip.bin firmware"

#Made a configuration changes in firmware to load rdkb stack.
LICENSE = "CLOSED"

COMPATIBLE_MACHINE  = "^filogic$"

inherit deploy

PROVIDES= "atf_bootloader_prebuild"

#Speific to BPIR4 bootloader binary files only, nothing to build.
do_compile[noexec] = "1"
do_configure[noexec] = "1"

# also get rid of the default dependency added in bitbake.conf
# since there is no 'main' package generated (empty)
RDEPENDS:${PN}-dev = ""

SRC_URI += " file://bpi-r4_sdmmc_bl2.img \
                    file://bpi-r4_sdmmc_fip.bin"

do_deploy() {
        mkdir -p ${DEPLOYDIR}/atf/
        install -m 0644 ${WORKDIR}/bpi-r4_sdmmc_bl2_6-6.img ${DEPLOYDIR}/atf/
        install -m 0644 ${WORKDIR}/bpi-r4_sdmmc_fip_6-6.bin ${DEPLOYDIR}/atf/
}
addtask do_deploy after do_install
