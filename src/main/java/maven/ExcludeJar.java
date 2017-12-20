package maven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by ³¾¶« on 2016/2/24.
 */
public class ExcludeJar {

    public static void main(String[] args) throws IOException {
        String dep = "[INFO] +- com.tmall.campaign:tmallcampaign-client:jar:1.8.6:compile\n" +
                "[INFO] |  +- com.tmall.tmpp:tmpp-biz-common:jar:1.1.17-SNAPSHOT:compile\n" +
                "[INFO] |  |  \\- org.apache.commons:commons-lang3:jar:3.1:compile\n" +
                "[INFO] |  +- com.taobao.ump:ump-sdk:jar:2.3.9:compile\n" +
                "[INFO] |  +- com.tmall.tmpp:tmpp-common:jar:1.1.54-SNAPSHOT:compile\n" +
                "[INFO] |  |  +- com.tmall.bbq:bbq-client:jar:2.9:compile\n" +
                "[INFO] |  |  +- com.google.protobuf:protobuf-java:jar:2.4.1:compile\n" +
                "[INFO] |  |  +- com.taobao.mallitemcenter:mic-common:jar:2.1.29:compile\n" +
                "[INFO] |  |  |  +- com.taobao.mallitemcenter:mic-share:jar:2.1.29-SNAPSHOT:compile\n" +
                "[INFO] |  |  |  |  \\- com.taobao.mallitemcenter:jackson:jar:1.0-SCM-mallitemcenter:compile\n" +
                "[INFO] |  |  |  +- com.tmall.finder:finder:jar:0.0.1-SNAPSHOT:compile\n" +
                "[INFO] |  |  |  +- com.taobao.hsf.hessian:hessian:jar:4.0.7.bugfix:compile\n" +
                "[INFO] |  |  |  +- com.taobao.pamirs.transaction:taobao-pamirs-transaction:jar:2.0.6:compile\n" +
                "[INFO] |  |  |  +- quartz:quartz:jar:1.6.0:compile\n" +
                "[INFO] |  |  |  +- org.jibx:jibx-run:jar:1.2.4.5:compile\n" +
                "[INFO] |  |  |  +- org.jibx:jibx-extras:jar:1.2.4.5:compile\n" +
                "[INFO] |  |  |  +- com.taobao.csp:switchcenter:jar:2.1.0.2:compile\n" +
                "[INFO] |  |  |  \\- com.taobao.place:place-client:jar:1.2.15-SNAPSHOT:compile\n" +
                "[INFO] |  |  |     \\- net.sourceforge:pinyin4j:jar:2.5.0:compile\n" +
                "[INFO] |  |  +- com.taobao.xmp:xmp-common-client:jar:1.8.7:compile\n" +
                "[INFO] |  |  +- com.taobao.xmp:xmp-core-client:jar:1.8.7:compile\n" +
                "[INFO] |  |  +- com.taobao.ump:ump-common-client:jar:3.2.9-overlayCoupon-SNAPSHOT:compile\n" +
                "[INFO] |  |  +- com.taobao.biz.traderule:traderule:jar:1.6.8:compile\n" +
                "[INFO] |  |  |  +- com.taobao.common.constants:common-constants:jar:1.0-SNAPSHOT:compile\n" +
                "[INFO] |  |  |  \\- org.apache.bcel:bcel:jar:5.2:compile\n" +
                "[INFO] |  |  |     \\- jakarta-regexp:jakarta-regexp:jar:1.4:compile\n" +
                "[INFO] |  |  +- com.dyuproject.protostuff:protostuff-api:jar:1.0.8:compile\n" +
                "[INFO] |  |  \\- com.tmall.tmpp:smart-cache:jar:2.0.6-SNAPSHOT:compile\n" +
                "[INFO] |  |     +- com.tmall:breakout:jar:0.9.1-SNAPSHOT:compile\n" +
                "[INFO] |  |     |  +- asm:asm:jar:3.3.1:compile\n" +
                "[INFO] |  |     |  +- asm:asm-commons:jar:3.3.1:compile\n" +
                "[INFO] |  |     |  +- asm:asm-util:jar:3.3.1:compile\n" +
                "[INFO] |  |     |  +- asm:asm-tree:jar:3.3.1:compile\n" +
                "[INFO] |  |     |  +- org.ow2.asm:asm-analysis:jar:4.0:compile\n" +
                "[INFO] |  |     |  |  \\- org.ow2.asm:asm-tree:jar:4.0:compile\n" +
                "[INFO] |  |     |  \\- net.sf.trove4j:trove4j:jar:3.0.3:compile\n" +
                "[INFO] |  |     +- com.dyuproject.protostuff:protostuff-core:jar:1.0.7:compile\n" +
                "[INFO] |  |     +- com.dyuproject.protostuff:protostuff-runtime:jar:1.0.7:compile\n" +
                "[INFO] |  |     |  \\- com.dyuproject.protostuff:protostuff-collectionschema:jar:1.0.7:compile\n" +
                "[INFO] |  |     \\- net.sf.flexjson:flexjson:jar:3.1:compile\n" +
                "[INFO] |  +- com.tmall.promotion:promotionarena-common:jar:1.0.5-SNAPSHOT:compile\n" +
                "[INFO] |  |  +- org.projectlombok:lombok:jar:0.10.4:compile\n" +
                "[INFO] |  |  +- com.taobao.itemcenter:itemutils:jar:1.2.2-SNAPSHOT:compile\n" +
                "[INFO] |  |  +- com.taobao.tagcenter:tagcenter-client:jar:1.2.4:compile\n" +
                "[INFO] |  |  \\- com.taobao.common.catserver:catserver-client:jar:2.2.4:compile\n" +
                "[INFO] |  |     \\- com.taobao.common.catserver:catserver-common:jar:2.2.4:compile\n" +
                "[INFO] |  |        \\- com.taobao.messenger:messenger-manager-common:jar:1.1.0:compile\n" +
                "[INFO] |  +- com.tmall.promotion:promotionarena-client:jar:4.8.5:compile\n" +
                "[INFO] |  |  +- com.alibaba.doa.ams-sdk:ams-sdk:jar:1.1.8.2:compile\n" +
                "[INFO] |  |  |  +- com.alibaba.doa.ams-sdk:ams-sdk-thick:jar:1.1.8.2:compile\n" +
                "[INFO] |  |  |  |  +- com.alibaba.doa.ams:ams-thick-client:jar:1.1.8.2:compile\n" +
                "[INFO] |  |  |  |  |  +- com.alibaba.doa.ams:ams-indexbuilder:jar:1.1.8.2:compile\n" +
                "[INFO] |  |  |  |  |  |  \\- com.alibaba.doa.ams:ams-entity:jar:1.1.8.2:compile\n" +
                "[INFO] |  |  |  |  |  |     \\- com.alibaba.doa.ams:ams-lock:jar:1.1.8.2:compile\n" +
                "[INFO] |  |  |  |  |  \\- org.slf4j:slf4j-simple:jar:1.7.10:compile\n" +
                "[INFO] |  |  |  |  \\- com.alibaba.doa.ams-sdk:ams-sdk-common:jar:1.1.8.2:compile\n" +
                "[INFO] |  |  |  \\- com.alibaba.doa.ams-sdk:ams-sdk-thin:jar:1.1.8.2:compile\n" +
                "[INFO] |  |  |     +- com.alibaba.doa.ams:ams-thin-client:jar:1.1.8.2:compile\n" +
                "[INFO] |  |  |     |  \\- com.alibaba.doa.ams:ams-common:jar:1.1.8.2:compile\n" +
                "[INFO] |  |  |     \\- javax.servlet:servlet-api:jar:3.0:compile\n" +
                "[INFO] |  |  +- mysql:mysql-connector-java:jar:5.1.6:compile\n" +
                "[INFO] |  |  +- com.alibaba:druid:jar:1.0.20:compile\n" +
                "[INFO] |  |  |  +- com.alibaba:jconsole:jar:1.8.0:system\n" +
                "[INFO] |  |  |  \\- com.alibaba:tools:jar:1.8.0:system\n" +
                "[INFO] |  |  +- com.taobao.tddl:tddl-sequence:jar:3.5.2:compile (version managed from 5.1.23-2)\n" +
                "[INFO] |  |  +- com.taobao.delivery:delivery-common:jar:3.3.6.3:compile\n" +
                "[INFO] |  |  \\- com.taobao.common.division:common-division:jar:2.4.0:compile\n" +
                "[INFO] |  |     +- com.taobao.configserver:config-server-client:jar:1.5.5:compile\n" +
                "[INFO] |  |     \\- com.taobao.configserver:config-server-common:jar:1.5.5:compile\n" +
                "[INFO] |  |        \\- com.google.code.guice:guice:jar:1.0:compile\n" +
                "[INFO] |  +- com.tmall.baoming:promotion-client:jar:1.0.1-SNAPSHOT:compile\n" +
                "[INFO] |  |  \\- commons-codec:commons-codec:jar:1.6:compile\n" +
                "[INFO] |  +- com.taobao.security:security:jar:2.0-SNAPSHOT:compile\n" +
                "[INFO] |  |  +- com.alibaba.platform.shared:fasttext.all:jar:1.3-SNAPSHOT:compile\n" +
                "[INFO] |  |  +- org.htmlparser:htmlparser:jar:1.6:compile\n" +
                "[INFO] |  |  +- oro:oro:jar:2.0.8:compile\n" +
                "[INFO] |  |  +- net.sourceforge.nekohtml:nekohtml:jar:1.9.9:compile\n" +
                "[INFO] |  |  |  \\- xerces:xercesImpl:jar:2.8.1:compile\n" +
                "[INFO] |  |  +- org.apache.xmlgraphics:batik-css:jar:1.7:compile\n" +
                "[INFO] |  |  |  +- org.apache.xmlgraphics:batik-ext:jar:1.7:compile\n" +
                "[INFO] |  |  |  \\- xml-apis:xml-apis-ext:jar:1.3.04:compile\n" +
                "[INFO] |  |  +- org.apache.xmlgraphics:batik-util:jar:1.7:compile\n" +
                "[INFO] |  |  +- org.w3c.css:sac:jar:1.3:compile\n" +
                "[INFO] |  |  +- com.alibaba.toolkit:toolkit-webx-request:jar:2.0:compile\n" +
                "[INFO] |  |  +- com.alibaba.common.logging:toolkit-common-logging:jar:1.0:compile\n" +
                "[INFO] |  |  +- ecs:ecs:jar:1.4.2:compile\n" +
                "[INFO] |  |  +- com.alibaba.common.lang:toolkit-common-lang:jar:1.0:compile\n" +
                "[INFO] |  |  +- com.alibaba.toolkit:toolkit-service-framework:jar:1.0:compile\n" +
                "[INFO] |  |  +- com.alibaba.toolkit:toolkit-common-expression:jar:1.0:compile\n" +
                "[INFO] |  |  +- com.alibaba.toolkit:toolkit-service-form:jar:1.0:compile\n" +
                "[INFO] |  |  +- com.alibaba.toolkit:toolkit-service-threadcontext:jar:1.0:compile\n" +
                "[INFO] |  |  +- com.alibaba.toolkit:toolkit-webx-turbine:jar:2.0:compile\n" +
                "[INFO] |  |  +- com.alibaba.toolkit:toolkit-common-configuration:jar:1.0:compile\n" +
                "[INFO] |  |  +- commons-jelly:commons-jelly:jar:1.0-RC1:compile\n" +
                "[INFO] |  |  |  +- commons-discovery:commons-discovery:jar:20030211.213356:compile\n" +
                "[INFO] |  |  |  +- forehead:forehead:jar:1.0-beta-5:compile\n" +
                "[INFO] |  |  |  \\- javax.servlet:jstl:jar:1.0.6:compile\n" +
                "[INFO] |  |  +- com.alibaba.toolkit:toolkit-service-rundata:jar:1.0:compile\n" +
                "[INFO] |  |  +- com.alibaba.toolkit:toolkit-webx-framework:jar:2.0:compile\n" +
                "[INFO] |  |  +- com.alibaba.toolkit:toolkit-service-pipeline:jar:1.0:compile\n" +
                "[INFO] |  |  +- com.alibaba.toolkit:toolkit-service-pull:jar:1.0:compile\n" +
                "[INFO] |  |  +- xml-apis:xml-apis:jar:1.0.b2:compile\n" +
                "[INFO] |  |  \\- org.apache.velocity:velocity-tools:jar:1.4:compile\n" +
                "[INFO] |  |     +- commons-digester:commons-digester:jar:1.8:compile\n" +
                "[INFO] |  |     +- commons-chain:commons-chain:jar:1.1:compile\n" +
                "[INFO] |  |     +- commons-validator:commons-validator:jar:1.3.1:compile\n" +
                "[INFO] |  |     +- sslext:sslext:jar:1.2-0:compile\n" +
                "[INFO] |  |     +- org.apache.struts:struts-core:jar:1.3.8:compile\n" +
                "[INFO] |  |     |  \\- antlr:antlr:jar:2.7.2:compile\n" +
                "[INFO] |  |     +- org.apache.struts:struts-taglib:jar:1.3.8:compile\n" +
                "[INFO] |  |     \\- org.apache.struts:struts-tiles:jar:1.3.8:compile\n" +
                "[INFO] |  +- com.tmall.nova:nova-client:jar:1.4.0-SNAPSHOT:compile\n" +
                "[INFO] |  |  +- com.taobao.punishcenter:punishclient:jar:1.4.6:compile\n" +
                "[INFO] |  |  +- com.taobao.common.uic.uic-localcache:common-uic-localcache:jar:1.0.0:compile\n" +
                "[INFO] |  |  +- com.taobao.dw:pointer-rmi-client:jar:1.0.2:compile\n" +
                "[INFO] |  |  \\- com.taobao.mallitemcenter:mic-client:jar:2.1.3:compile\n" +
                "[INFO] |  |     \\- com.taobao.hsf:hsf.lib:jar:1.4.2:compile\n" +
                "[INFO] |  +- log4j:log4j:jar:1.2.17:compile\n" +
                "[INFO] |  +- com.taobao.util:util:jar:1.2.6:compile\n" +
                "[INFO] |  +- com.alibaba.toolkit.common.logging:logging:jar:1.0:compile\n" +
                "[INFO] |  +- com.alibaba.toolkit.biz.command:command:jar:1.0:compile\n" +
                "[INFO] |  +- com.taobao.forest:forest-client:jar:5.4.5.1:compile\n" +
                "[INFO] |  |  +- com.taobao.forest:forest-common:jar:5.4.5.1:compile\n" +
                "[INFO] |  |  +- com.taobao.forest:forest-store:jar:5.4.5.1:compile\n" +
                "[INFO] |  |  +- com.taobao.forest:forest-domaindefault:jar:5.4.5.1:compile\n" +
                "[INFO] |  |  \\- com.taobao.skylight:skylight-client:jar:2.1.9.0:compile\n" +
                "[INFO] |  |     +- com.taobao.skylight:skylight-meta:jar:2.1.9.0:compile\n" +
                "[INFO] |  |     |  \\- com.taobao.skylight:skylight-common:jar:2.1.9.0:compile\n" +
                "[INFO] |  |     \\- com.taobao.skylight.engine:skylight-engine-client:jar:3.0.5.9:compile\n" +
                "[INFO] |  |        +- com.taobao.skylight.engine:skylight-api:jar:3.0.5.9:compile\n" +
                "[INFO] |  |        \\- com.taobao.skylight.engine:skylight-core:jar:3.0.5.9:compile\n" +
                "[INFO] |  |           +- com.taobao.skylight.engine:skylight-dsl:jar:3.0.5.9:compile\n" +
                "[INFO] |  |           |  +- org.mvel:mvel2:jar:2.0.19:compile\n" +
                "[INFO] |  |           |  \\- org.antlr:antlr-runtime:jar:3.5.2:compile\n" +
                "[INFO] |  |           \\- com.taobao.eagleeye:eagleeye-logs:jar:1.3.0:compile\n" +
                "[INFO] |  +- com.taobao.forest:forest-domain:jar:5.4.5.1:compile\n" +
                "[INFO] |  |  \\- com.fasterxml.jackson.core:jackson-databind:jar:2.2.3:compile\n" +
                "[INFO] |  |     +- com.fasterxml.jackson.core:jackson-annotations:jar:2.2.3:compile\n" +
                "[INFO] |  |     \\- com.fasterxml.jackson.core:jackson-core:jar:2.2.3:compile\n" +
                "[INFO] |  +- com.taobao.itemcenter:itemcenter-client:jar:99.0-does-not-exist:compile\n" +
                "[INFO] |  +- com.taobao.itemcenter:itemcenter-common:jar:2.4.1.2:compile\n" +
                "[INFO] |  |  +- com.taobao.common.nbeanutils:common-nbeanutils:jar:1.0:compile\n" +
                "[INFO] |  |  +- org.apache.httpcomponents:httpclient:jar:4.3.1:compile\n" +
                "[INFO] |  |  |  \\- org.apache.httpcomponents:httpcore:jar:4.3:compile\n" +
                "[INFO] |  |  +- com.taobao.hsf:hsf.notify.spring:jar:1.4.9.6:compile\n" +
                "[INFO] |  |  |  \\- com.taobao.notify:notify-tr-client:jar:1.8.19.26:compile (version managed from 1.8.15)\n" +
                "[INFO] |  |  |     +- com.taobao.notify:notify-common:jar:1.8.19.26:compile\n" +
                "[INFO] |  |  |     +- com.taobao.notify:notify-remoting:jar:1.8.19.26:compile\n" +
                "[INFO] |  |  |     |  \\- com.taobao.gecko:gecko:jar:1.1.4.1:compile\n" +
                "[INFO] |  |  |     \\- com.taobao.notify:notify-store4j:jar:1.8.19.26:compile\n" +
                "[INFO] |  |  +- com.taobao.tagcenter:tagcenter-common:jar:1.2.5.2:compile\n" +
                "[INFO] |  |  +- com.taobao.tsp.framework:tsp-framework-utils-async-http:jar:1.0.4:compile\n" +
                "[INFO] |  |  |  +- org.apache.asyncweb:asyncweb-client:jar:1.0.0-SNAPSHOT:compile\n" +
                "[INFO] |  |  |  |  \\- org.apache.mina:mina-filter-ssl:jar:1.1.7:compile\n" +
                "[INFO] |  |  |  \\- com.taobao.tsp.framework:tsp-framework-core:jar:1.0.4:compile\n" +
                "[INFO] |  |  +- com.taobao.itemcenter.toolkit:itemcenter-protobuf-java:jar:2.3.6.9.1:compile\n" +
                "[INFO] |  |  +- com.ning:compress-lzf:jar:0.6.0:compile\n" +
                "[INFO] |  |  +- com.taobao.vsearch:vsearch-client:jar:2.7.5:compile\n" +
                "[INFO] |  |  |  +- org.codehaus.woodstox:wstx-asl:jar:3.2.7:compile\n" +
                "[INFO] |  |  |  +- org.apache.geronimo.specs:geronimo-stax-api_1.0_spec:jar:1.0.1:compile\n" +
                "[INFO] |  |  |  \\- com.taobao.vcar:vcar-bulldozer:jar:1.2.4:compile\n" +
                "[INFO] |  |  |     +- com.taobao.vsearch:vsearch-zk:jar:3.2.1.17:compile\n" +
                "[INFO] |  |  |     +- com.sun.jdmk:jmxtools:jar:1.2.1:compile\n" +
                "[INFO] |  |  |     +- org.jboss.netty:netty:jar:3.2.1.Final:compile\n" +
                "[INFO] |  |  |     \\- fast-md5:fast-md5:jar:2.5:compile\n" +
                "[INFO] |  |  +- com.taobao.vsearch:vsearch-extends:jar:1.0.2:compile\n" +
                "[INFO] |  |  +- net.sf.json-lib:json-lib:jar:2.2.3:compile\n" +
                "[INFO] |  |  +- com.taobao.common.catserver:millau-bo:jar:1.1.9.3:compile\n" +
                "[INFO] |  |  +- com.taobao.inventory:ip-commons:jar:3.10.1:compile\n" +
                "[INFO] |  |  |  +- org.simpleframework:simple-xml:jar:2.7.1:compile\n" +
                "[INFO] |  |  |  |  \\- stax:stax:jar:1.2.0:compile\n" +
                "[INFO] |  |  |  \\- com.taobao.scsku:scsku-client:jar:1.2.3-final:compile\n" +
                "[INFO] |  |  +- com.taobao.scsku:scsku-common:jar:1.2.3-final:compile\n" +
                "[INFO] |  |  |  +- com.taobao.util:taobao-express:jar:2.2.7:compile\n" +
                "[INFO] |  |  |  +- com.taobao.tmutil:tmutil:jar:1.0.1-SNAPSHOT:compile\n" +
                "[INFO] |  |  |  |  \\- com.taobao.config.client.helper:config-client-helper:jar:1.4:compile\n" +
                "[INFO] |  |  |  +- com.tmall.cloud.integration:data-mapping:jar:1.0-SNAPSHOT:compile\n" +
                "[INFO] |  |  |  |  +- com.tmall.cloud.integration:mapping-tools:jar:1.0-SNAPSHOT:compile\n" +
                "[INFO] |  |  |  |  |  \\- com.jamesmurty.utils:java-xmlbuilder:jar:0.4:compile\n" +
                "[INFO] |  |  |  |  +- xalan:xalan:jar:2.7.1:compile\n" +
                "[INFO] |  |  |  |  |  \\- xalan:serializer:jar:2.7.1:compile\n" +
                "[INFO] |  |  |  |  +- org.slf4j:jul-to-slf4j:jar:1.6.1:compile\n" +
                "[INFO] |  |  |  |  +- org.perf4j:perf4j:jar:0.9.16:compile\n" +
                "[INFO] |  |  |  |  +- de.odysseus.staxon:staxon:jar:1.2:compile\n" +
                "[INFO] |  |  |  |  \\- de.odysseus.staxon:staxon-jackson:jar:1.2:compile\n" +
                "[INFO] |  |  |  \\- com.tmall.cloud.integration:service-proxy:jar:1.0-SNAPSHOT:compile\n" +
                "[INFO] |  |  |     \\- com.taobao.hsf.ndi:hsf.app.ndi:jar:1.4.9.2-tae:compile\n" +
                "[INFO] |  |  +- com.taobao.inventory:iphotel-client:jar:2.2.7.8:compile\n" +
                "[INFO] |  |  |  \\- com.taobao.hsf:hsf.services:jar:1.4.9:compile\n" +
                "[INFO] |  |  +- com.taobao.pricecenter:pricecenter-client:jar:2.1.4.3:compile\n" +
                "[INFO] |  |  |  \\- com.alibaba.service.platform:dataservice:jar:1.0-SNAPSHOT:compile\n" +
                "[INFO] |  |  +- com.alibaba.service:price-service-common:jar:2.1.4.3:compile\n" +
                "[INFO] |  |  |  +- com.taobao.itemdims:itemdims-share:jar:2.1.4.3:compile\n" +
                "[INFO] |  |  |  \\- com.taobao.gps:gps.container:jar:1.0.1:compile\n" +
                "[INFO] |  |  |     \\- com.taobao.gps:gps.bootstrap:jar:1.0.1:compile\n" +
                "[INFO] |  |  |        \\- com.taobao.gps:gps.plugins:jar:1.0.1:compile\n" +
                "[INFO] |  |  |           \\- com.taobao.gps:gps.core:jar:1.0.1:compile\n" +
                "[INFO] |  |  |              \\- com.google.inject:guice:jar:4.0-beta4:compile\n" +
                "[INFO] |  |  |                 \\- javax.inject:javax.inject:jar:1:compile\n" +
                "[INFO] |  |  +- com.taobao.pricecenter:pricecenter-common:jar:2.1.4.3:compile\n" +
                "[INFO] |  |  |  \\- com.taobao.thboss:thboss-common:jar:1.0.2:compile\n" +
                "[INFO] |  |  |     +- com.taobao.common.payway:common-payway:jar:4.2.11:compile\n" +
                "[INFO] |  |  |     |  +- com.alibaba.headquarters.biz.common:common:jar:1.1:compile\n" +
                "[INFO] |  |  |     |  +- com.alibaba.toolkit.service.framework:framework:jar:1.0:compile\n" +
                "[INFO] |  |  |     |  +- com.alibaba.toolkit.service.dsa:dsa:jar:1.0:compile\n" +
                "[INFO] |  |  |     |  +- com.alibaba.toolkit.webx.filter:filter:jar:2.0:compile\n" +
                "[INFO] |  |  |     |  +- com.alibaba.toolkit.service.resource:resource:jar:1.0:compile\n" +
                "[INFO] |  |  |     |  +- com.taobao.common.keycenter.keycenter-common:common-keycenter-common:jar:1.2:compile\n" +
                "[INFO] |  |  |     |  \\- com.taobao.common.keycenter.keycenter-client:common-keycenter-client:jar:1.2:compile\n" +
                "[INFO] |  |  |     +- com.taobao.hstb:ems:jar:1.0.6:compile\n" +
                "[INFO] |  |  |     \\- fel:fel-all:jar:0.9:compile\n" +
                "[INFO] |  |  +- com.taobao.terminator:terminator-client-standalone:jar:3.1.5.10.4-fix4ic:compile\n" +
                "[INFO] |  |  |  +- org.jdom:jdom:jar:1.1:compile\n" +
                "[INFO] |  |  |  \\- org.json:json:jar:2.2:compile\n" +
                "[INFO] |  |  +- com.alibaba.tissot:tissot-core:jar:1.3.0:compile\n" +
                "[INFO] |  |  |  \\- jaxen:jaxen:jar:1.1.1:compile\n" +
                "[INFO] |  |  |     \\- xom:xom:jar:1.0:compile\n" +
                "[INFO] |  |  |        \\- xerces:xmlParserAPIs:jar:2.6.2:compile\n" +
                "[INFO] |  |  +- com.caucho:hessian:jar:3.1.3:compile\n" +
                "[INFO] |  |  +- com.github.fge:json-schema-validator:jar:2.2.5:compile\n" +
                "[INFO] |  |  |  +- com.github.fge:json-schema-core:jar:1.2.4:compile\n" +
                "[INFO] |  |  |  |  +- com.github.fge:uri-template:jar:0.9:compile\n" +
                "[INFO] |  |  |  |  |  \\- com.github.fge:msg-simple:jar:1.1:compile\n" +
                "[INFO] |  |  |  |  |     \\- com.github.fge:btf:jar:1.2:compile\n" +
                "[INFO] |  |  |  |  +- com.github.fge:jackson-coreutils:jar:1.8:compile\n" +
                "[INFO] |  |  |  |  \\- org.mozilla:rhino:jar:1.7R4:compile\n" +
                "[INFO] |  |  |  +- joda-time:joda-time:jar:2.3:compile\n" +
                "[INFO] |  |  |  +- com.googlecode.libphonenumber:libphonenumber:jar:6.0:compile\n" +
                "[INFO] |  |  |  +- javax.mail:mailapi:jar:1.4.3:compile\n" +
                "[INFO] |  |  |  |  \\- javax.activation:activation:jar:1.1:compile\n" +
                "[INFO] |  |  |  \\- net.sf.jopt-simple:jopt-simple:jar:4.6:compile\n" +
                "[INFO] |  |  +- com.alibaba.taxcenter:taxcenter-client:jar:1.2.17:compile\n" +
                "[INFO] |  |  |  \\- com.alibaba.cainiao:customsplatform-client:jar:1.3.0:compile\n" +
                "[INFO] |  |  |     \\- com.alibaba.shared:toolkit.common.resourcebundle:jar:1.0:compile\n" +
                "[INFO] |  |  |        +- com.alibaba.shared:toolkit.common.collection:jar:1.0:compile\n" +
                "[INFO] |  |  |        +- com.alibaba.shared:toolkit.service.resource:jar:1.0:compile\n" +
                "[INFO] |  |  |        |  +- com.alibaba.shared:toolkit.service.framework:jar:1.0:compile\n" +
                "[INFO] |  |  |        |  |  +- com.alibaba.shared:toolkit.common.logging:jar:1.0:compile\n" +
                "[INFO] |  |  |        |  |  \\- com.alibaba.shared:toolkit.common.configuration:jar:1.0:compile\n" +
                "[INFO] |  |  |        |  |     +- com.alibaba.external:jakarta.commons.configuration:jar:0.0.0:compile\n" +
                "[INFO] |  |  |        |  |     +- com.alibaba.external:jakarta.commons.jelly:jar:0.0.0:compile\n" +
                "[INFO] |  |  |        |  |     \\- com.alibaba.external:jakarta.commons.beanutils:jar:0.0.0:compile\n" +
                "[INFO] |  |  |        |  \\- com.alibaba.shared:toolkit.common.regexp:jar:1.0:compile\n" +
                "[INFO] |  |  |        \\- com.alibaba.shared:toolkit.service.pull:jar:1.0:compile\n" +
                "[INFO] |  |  |           +- com.alibaba.shared:toolkit.service.template:jar:1.0:compile\n" +
                "[INFO] |  |  |           +- com.alibaba.shared:toolkit.service.pool:jar:1.0:compile\n" +
                "[INFO] |  |  |           \\- com.alibaba.shared:toolkit.service.threadcontext:jar:1.0:compile\n" +
                "[INFO] |  |  +- com.taobao.csp:sentinel:jar:2.12.0:compile\n" +
                "[INFO] |  |  |  \\- com.taobao.csp:courier:jar:1.0.6-SNAPSHOT:compile\n" +
                "[INFO] |  |  +- com.taobao.item:region-common:jar:1.0.4:compile\n" +
                "[INFO] |  |  |  \\- com.google.guava:guava.hsf:jar:18.0:compile\n" +
                "[INFO] |  |  +- com.taobao.item:region-client:jar:1.0.4:compile\n" +
                "[INFO] |  |  \\- org.alibaba.ha3:ha3-client:jar:1.0.7:compile\n" +
                "[INFO] |  +- com.taobao.common.tair:common-tair:jar:2.2.5:compile\n" +
                "[INFO] |  +- net.sf.json-lib:json-lib:jar:jdk15-fixed:2.2.2:compile\n" +
                "[INFO] |  +- net.sourceforge.jexcelapi:jxl:jar:2.6:compile\n" +
                "[INFO] |  +- org.apache.poi:poi-ooxml:jar:3.8:compile\n" +
                "[INFO] |  |  \\- org.apache.poi:poi-ooxml-schemas:jar:3.8:compile\n" +
                "[INFO] |  |     \\- org.apache.xmlbeans:xmlbeans:jar:2.3.0:compile\n" +
                "[INFO] |  +- com.taobao.notify:common-cs:jar:1.2.1:compile\n" +
                "[INFO] |  +- com.taobao.memberprofile:tag-tair:jar:0.5:compile\n" +
                "[INFO] |  +- com.taobao.common.smonitor:smonitor:jar:1.0.4:compile\n" +
                "[INFO] |  +- com.alibaba.oplog:oplog.collector.client:jar:2.0.6:compile\n" +
                "[INFO] |  |  \\- com.alibaba.cdo:timetunnel-clientng:jar:0.4.1-2-SNAPSHOT:compile\n" +
                "[INFO] |  |     \\- com.taobao:timetunnel-client:jar:0.4.2-SNAPSHOT:compile\n" +
                "[INFO] |  |        +- com.taobao:timetunnel-idl:jar:0.4.1:compile\n" +
                "[INFO] |  |        |  \\- org.apache.thrift:libthrift:jar:0.8.0:compile\n" +
                "[INFO] |  |        \\- com.github.sgroschupf:zkclient:jar:0.1:compile\n" +
                "[INFO] |  +- com.alibaba.oplog:oplog.searcher.client:jar:2.0.0-SNAPSHOT:compile\n" +
                "[INFO] |  +- apache-xerces:xercesImpl:jar:2.9.1:compile\n" +
                "[INFO] |  +- com.tmall.neo.admin:presale-client:jar:1.0.6-SNAPSHOT:compile\n" +
                "[INFO] |  |  +- com.taobao.misccenter:misccenter-common:jar:1.8.5-discount-SNAPSHOT:compile\n" +
                "[INFO] |  |  |  +- com.alibaba.toolkit:toolkit-biz-command:jar:1.0:compile\n" +
                "[INFO] |  |  |  +- com.taobao.vic:vic-common:jar:1.1.0:compile\n" +
                "[INFO] |  |  |  +- com.taobao.biz.alipayaccount:alipayaccount:jar:3.1.4:compile\n" +
                "[INFO] |  |  |  +- org.projectlombok:maven-lombok-plugin:jar:0.9.3.1:compile\n" +
                "[INFO] |  |  |  |  \\- org.apache.maven:maven-plugin-api:jar:2.0.9:compile\n" +
                "[INFO] |  |  |  +- com.taobao.tradesecurity:ts-client:jar:1.0.1-SNAPSHOT:compile\n" +
                "[INFO] |  |  |  |  \\- com.taobao.sharereport:share-report-common:jar:1.5.1-SNAPSHOT:compile\n" +
                "[INFO] |  |  |  +- com.taobao.notify:notify-utils:jar:1.8.19.26:compile\n" +
                "[INFO] |  |  |  |  +- bcel:bcel:jar:5.1:compile\n" +
                "[INFO] |  |  |  |  +- org.jasypt:jasypt:jar:1.5:compile\n" +
                "[INFO] |  |  |  |  +- com.ibm.icu:icu4j:jar:3.4.4:compile\n" +
                "[INFO] |  |  |  |  +- com.googlecode.aviator:aviator:jar:2.3.3:compile (version managed from 2.2.1)\n" +
                "[INFO] |  |  |  |  +- com.h2database:h2:jar:1.3.167:compile\n" +
                "[INFO] |  |  |  |  +- org.jdbi:jdbi:jar:2.38.1:compile\n" +
                "[INFO] |  |  |  |  \\- org.mockito:mockito-all:jar:1.9.0:compile\n" +
                "[INFO] |  |  |  +- com.alibaba.external:sourceforge.pinyin4j:jar:2.5.0:compile\n" +
                "[INFO] |  |  |  +- com.taobao.baoxian:zhonganbaoxianprod-bzj-client:jar:1.0.0-SNAPSHOT:compile\n" +
                "[INFO] |  |  |  |  \\- com.taobao.baoxian:baoxianxbc-common:jar:2.0.21:compile\n" +
                "[INFO] |  |  |  \\- com.taobao.wireless:mtop-hsf-agent:jar:1.0.9.3-SNAPSHOT:compile\n" +
                "[INFO] |  |  |     +- com.taobao.wireless:mtop-core-domain:jar:1.0.6-SNAPSHOT:compile\n" +
                "[INFO] |  |  |     |  \\- org.msgpack:msgpack:jar:0.6.9:compile\n" +
                "[INFO] |  |  |     |     \\- com.googlecode.json-simple:json-simple:jar:1.1.1:compile\n" +
                "[INFO] |  |  |     \\- com.taobao.wireless:mtop-base-core:jar:1.1.3-SNAPSHOT:compile\n" +
                "[INFO] |  |  +- com.taobao.misccenter:misccenter-client:jar:1.5.4.7:compile\n" +
                "[INFO] |  |  |  \\- com.taobao.top:top-mapping:jar:2.0.5.6:compile\n" +
                "[INFO] |  |  \\- com.alibaba.toolkit.common.resourcebundle:resourcebundle:jar:1.0:compile\n" +
                "[INFO] |  +- com.alibaba.barca:platform-domain:jar:1.0.5-SNAPSHOT:compile\n" +
                "[INFO] |  |  +- com.taobao:hsf-notify-client:jar:1.8.19.8:compile\n" +
                "[INFO] |  |  \\- com.alibaba.platform.shared:druid:jar:999-not-exist:compile\n" +
                "[INFO] |  +- com.tmall.rmc:rmc-client:jar:1.0.13-tmc-jdk16-SNAPSHOT:compile\n" +
                "[INFO] |  |  +- org.codehaus.jettison:jettison:jar:1.3.7:compile\n" +
                "[INFO] |  |  |  \\- stax:stax-api:jar:1.0.1:compile\n" +
                "[INFO] |  |  \\- com.tmall.ifframe.validator:if-validator:jar:1.3.3-SNAPSHOT:compile\n" +
                "[INFO] |  |     +- org.jsonschema2pojo:jsonschema2pojo-core:jar:0.4.7:compile\n" +
                "[INFO] |  |     |  +- com.sun.codemodel:codemodel:jar:2.6:compile\n" +
                "[INFO] |  |     |  +- org.codehaus.jackson:jackson-mapper-asl:jar:1.9.11:compile\n" +
                "[INFO] |  |     |  |  \\- org.codehaus.jackson:jackson-core-asl:jar:1.9.11:compile\n" +
                "[INFO] |  |     |  \\- com.google.code.findbugs:annotations:jar:1.3.9:compile\n" +
                "[INFO] |  |     +- com.taobao.media:commons-utils:jar:1.0.6-SNAPSHOT:compile\n" +
                "[INFO] |  |     |  +- opensymphony:quartz-all:jar:1.6.0:compile\n" +
                "[INFO] |  |     |  +- org.apache.commons:commons-digester3:jar:with-deps:3.2:compile\n" +
                "[INFO] |  |     |  |  \\- cglib:cglib:jar:2.2.2:compile\n" +
                "[INFO] |  |     |  +- org.apache.hbase:hbase:jar:0.94-adh3u2.1:compile\n" +
                "[INFO] |  |     |  |  +- com.yammer.metrics:metrics-core:jar:2.1.2:compile\n" +
                "[INFO] |  |     |  |  +- com.hadoop:hadoop-lzo:jar:0.4.11:compile\n" +
                "[INFO] |  |     |  |  +- com.github.stephenc.high-scale-lib:high-scale-lib:jar:1.1.1:compile\n" +
                "[INFO] |  |     |  |  +- org.apache.avro:avro:jar:1.5.3:compile\n" +
                "[INFO] |  |     |  |  +- org.apache.avro:avro-ipc:jar:1.5.3:compile\n" +
                "[INFO] |  |     |  |  +- org.jruby:jruby-complete:jar:1.6.5:compile\n" +
                "[INFO] |  |     |  |  +- org.mortbay.jetty:jetty:jar:6.1.26:compile\n" +
                "[INFO] |  |     |  |  +- org.mortbay.jetty:jsp-2.1:jar:6.1.14:compile\n" +
                "[INFO] |  |     |  |  |  \\- org.eclipse.jdt:core:jar:3.1.1:compile\n" +
                "[INFO] |  |     |  |  +- org.mortbay.jetty:jsp-api-2.1:jar:6.1.14:compile\n" +
                "[INFO] |  |     |  |  +- org.mortbay.jetty:servlet-api-2.5:jar:6.1.14:compile\n" +
                "[INFO] |  |     |  |  +- org.codehaus.jackson:jackson-jaxrs:jar:1.8.8:compile\n" +
                "[INFO] |  |     |  |  +- org.codehaus.jackson:jackson-xc:jar:1.8.8:compile\n" +
                "[INFO] |  |     |  |  +- tomcat:jasper-compiler:jar:5.5.23:runtime\n" +
                "[INFO] |  |     |  |  +- tomcat:jasper-runtime:jar:5.5.23:runtime\n" +
                "[INFO] |  |     |  |  |  \\- commons-el:commons-el:jar:1.0:runtime\n" +
                "[INFO] |  |     |  |  +- org.jamon:jamon-runtime:jar:2.3.1:compile\n" +
                "[INFO] |  |     |  |  +- com.sun.jersey:jersey-core:jar:1.4:compile\n" +
                "[INFO] |  |     |  |  +- com.sun.jersey:jersey-json:jar:1.4:compile\n" +
                "[INFO] |  |     |  |  +- com.sun.jersey:jersey-server:jar:1.4:compile\n" +
                "[INFO] |  |     |  |  \\- javax.xml.bind:jaxb-api:jar:2.1:compile\n" +
                "[INFO] |  |     |  +- com.sun.media:jai-codec:jar:1.1.3:compile\n" +
                "[INFO] |  |     |  |  \\- javax.media:jai-core:jar:1.1.3:compile\n" +
                "[INFO] |  |     |  \\- com.alibaba.platform.shared:simpleimage:jar:1.1.7:compile\n" +
                "[INFO] |  |     |     +- com.alibaba.external:jakarta.commons.io:jar:0.0.0:compile\n" +
                "[INFO] |  |     |     +- com.alibaba.external:jakarta.commons.lang:jar:2.4:compile\n" +
                "[INFO] |  |     |     +- com.alibaba.external:jakarta.log4j:jar:0.0.0:compile\n" +
                "[INFO] |  |     |     \\- com.alibaba.external:jakarta.commons.logging:jar:0.0.0:compile\n" +
                "[INFO] |  |     +- org.sharegov:mjson:jar:1.3:compile\n" +
                "[INFO] |  |     \\- com.jayway.jsonpath:json-path:jar:2.0.0:compile\n" +
                "[INFO] |  |        \\- net.minidev:json-smart:jar:2.1.1:compile\n" +
                "[INFO] |  |           \\- net.minidev:asm:jar:1.0.2:compile\n" +
                "[INFO] |  +- com.taobao.tpe:tpe-client:jar:2.0.35-SNAPSHOT:compile\n" +
                "[INFO] |  |  \\- com.taobao.tpe:tpe-domain:jar:2.0.35-SNAPSHOT:compile\n" +
                "[INFO] |  +- com.taobao.trade.platform:tp-client:jar:1.10.12:compile\n" +
                "[INFO] |  |  +- com.taobao.trade.platform:tp-client-base:jar:1.10.12:compile\n" +
                "[INFO] |  |  |  +- com.taobao.refundplatform:rp-common:jar:1.3.15:compile\n" +
                "[INFO] |  |  |  +- com.taobao.refundplatform:rp-client:jar:1.3.15:compile\n" +
                "[INFO] |  |  |  +- com.taobao.hsf:hsf-extend:jar:0.0.5:compile\n" +
                "[INFO] |  |  |  +- com.taobao.fundgateway:fgw-client-extend:jar:1.0.24-fgw-SNAPSHOT:compile\n" +
                "[INFO] |  |  |  +- com.taobao.fundgateway:fgw-client:jar:1.0.24-fgw-SNAPSHOT:compile\n" +
                "[INFO] |  |  |  +- com.taobao.wireless:mtop-common-service:jar:1.0.3-SCM-tradeplatform:compile\n" +
                "[INFO] |  |  |  +- com.tmall.item.darwin:darwin-common:jar:1.3.3:compile\n" +
                "[INFO] |  |  |  |  +- com.tmall.beehive:beehive-system:jar:1.3.6:compile\n" +
                "[INFO] |  |  |  |  +- com.tmall.beehive:beehive-common:jar:1.3.6:compile\n" +
                "[INFO] |  |  |  |  |  \\- com.taobao.security:richtextfilter:jar:1.2.7:compile\n" +
                "[INFO] |  |  |  |  \\- com.tmall.beehive:beehive-util:jar:1.3.6:compile\n" +
                "[INFO] |  |  |  +- com.taobao.trade:tradeback-client:jar:1.0.0-SCM-tradeplatform:compile\n" +
                "[INFO] |  |  |  +- com.taobao.trade.timeout:toc-client:jar:1.0.34-SCM-tradeplatform:compile\n" +
                "[INFO] |  |  |  |  \\- com.taobao.tpn:tpn-client:jar:1.1.4-SCM-tradeplatform:compile\n" +
                "[INFO] |  |  |  +- com.alibaba.unit:unitrouter-ext:jar:1.0.3:compile\n" +
                "[INFO] |  |  |  +- com.cainiao.cdc:cdc-utils:jar:1.0.0:compile\n" +
                "[INFO] |  |  |  \\- com.taobao.logistics:logistics-common:jar:2.8.5.4:compile\n" +
                "[INFO] |  |  \\- com.taobao.trade.platform:tp-client-extend:jar:1.10.12:compile\n" +
                "[INFO] |  |     +- com.tmall.promotion:tmallpromotion-common:jar:2.0.1:compile\n" +
                "[INFO] |  |     +- com.tmall.promotion:tmallpromotion-client:jar:2.1.2.9-SCM-tradeplatform:compile\n" +
                "[INFO] |  |     |  +- com.taobao.uic:uic-client:jar:2.0:compile\n" +
                "[INFO] |  |     |  |  \\- com.taobao.uic:uic-thunderbird:jar:2.0:compile\n" +
                "[INFO] |  |     |  |     \\- org.apache.mina:mina-integration-jmx:jar:1.1.5:compile\n" +
                "[INFO] |  |     |  \\- com.taobao.pushit:pushit:jar:1.0.1-SCM-tradeplatform:compile\n" +
                "[INFO] |  |     +- com.taobao.ju:ju-toolkit:jar:1.0.41:compile\n" +
                "[INFO] |  |     |  \\- com.alibaba.toolkit:toolkit-common-logging:jar:1.0:compile\n" +
                "[INFO] |  |     +- com.taobao.hsf:hsf.service.tbremoting.invoke.future:jar:1.4.9.6:compile\n" +
                "[INFO] |  |     +- com.taobao.inventory:ip-client:jar:3.9.88-ROUTE-SNAPSHOT:compile\n" +
                "[INFO] |  |     |  +- org.hibernate:hibernate-validator:jar:4.0.2.GA:compile\n" +
                "[INFO] |  |     |  |  \\- com.sun.xml.bind:jaxb-impl:jar:2.1.3:compile\n" +
                "[INFO] |  |     |  +- com.cainiao.cdc:cdc-client:jar:1.0.4:compile\n" +
                "[INFO] |  |     |  +- com.cainiao.cdc:cdc-common:jar:1.1.6:compile\n" +
                "[INFO] |  |     |  |  +- com.alibaba.middleware.liaoyuan:liaoyuan-client:jar:2.4.0:compile\n" +
                "[INFO] |  |     |  |  |  \\- org.javatuples:javatuples:jar:1.2:compile\n" +
                "[INFO] |  |     |  |  +- com.cainiao.cdc.quarks:quarks-common:jar:0.9.1-SNAPSHOT:compile\n" +
                "[INFO] |  |     |  |  +- com.taobao.wlb:resourcecenter-pony:jar:3.1.0.26:compile\n" +
                "[INFO] |  |     |  |  |  +- com.taobao.wlb:resourcecenter-api:jar:3.1.0.21:compile\n" +
                "[INFO] |  |     |  |  |  |  \\- com.cainiao.dicrc:dic-rc-api:jar:1.0.10:compile\n" +
                "[INFO] |  |     |  |  |  +- com.cainiao.rc:coordinate:jar:1.0.3:compile\n" +
                "[INFO] |  |     |  |  |  +- com.zaxxer:HikariCP-java6:jar:2.3.13:compile\n" +
                "[INFO] |  |     |  |  |  +- org.xerial:sqlite-jdbc:jar:3.15.1:compile\n" +
                "[INFO] |  |     |  |  |  +- com.healthmarketscience.sqlbuilder:sqlbuilder:jar:2.1.5:compile\n" +
                "[INFO] |  |     |  |  |  |  \\- com.healthmarketscience.common:common-util:jar:1.1.1:compile\n" +
                "[INFO] |  |     |  |  |  +- commons-dbutils:commons-dbutils:jar:1.6:compile\n" +
                "[INFO] |  |     |  |  |  \\- com.aliyun.oss:aliyun-sdk-oss:jar:2.0.6:compile (version managed from 2.3.0)\n" +
                "[INFO] |  |     |  |  +- com.taobao.wlb:resourcecenter-common:jar:3.1.0.26:compile\n" +
                "[INFO] |  |     |  |  |  +- com.cainiao.common:cainiao-lang:jar:1.0.4:compile\n" +
                "[INFO] |  |     |  |  |  \\- pinyin4j:pinyin4j:jar:2.5.0:compile\n" +
                "[INFO] |  |     |  |  \\- com.taobao.csp:hotsensor:jar:1.0.2:compile\n" +
                "[INFO] |  |     |  +- com.taobao.delivery:warehouse-route-client:jar:1.4.5:compile\n" +
                "[INFO] |  |     |  +- com.tmall.sic:sic-client:jar:1.3.3-STORE-SNAPSHOT:compile\n" +
                "[INFO] |  |     |  |  \\- com.tmall.sic:sic-common:jar:1.3.3-STORE-SNAPSHOT:compile\n" +
                "[INFO] |  |     |  |     \\- net.jpountz.lz4:lz4:jar:1.3.0:compile\n" +
                "[INFO] |  |     |  \\- com.taobao.wlb:wlb-client:jar:2.3.7.3-SCM-inventoryplatform:compile\n" +
                "[INFO] |  |     |     +- com.taobao.pamirs.commons:pamirs-commons:jar:1.2.2.10:compile\n" +
                "[INFO] |  |     |     \\- com.taobao.wlb.account:wlb-account-client:jar:2.1-SCM-inventoryplatform:compile\n" +
                "[INFO] |  |     |        +- com.alibaba-inc.yunti:hadoop-common:jar:0.19.1-dc-r309802:compile\n" +
                "[INFO] |  |     |        +- com.alibaba-inc.yunti:hadoop-hdfs:jar:0.19.1-dc-r309802:compile\n" +
                "[INFO] |  |     |        +- com.alibaba-inc.yunti:hadoop-mapred:jar:0.19.1-dc-r309802:compile\n" +
                "[INFO] |  |     |        \\- com.alibaba.yunti:hadoop-auth:jar:2.0.0-cdh4.0.1:compile\n" +
                "[INFO] |  |     \\- javax.resource:connector:jar:1.0:compile\n" +
                "[INFO] |  +- com.taobao.trade:traderulecenter-client:jar:1.0.7-SNAPSHOT:compile\n" +
                "[INFO] |  |  +- javax.validation:validation-api:jar:1.0.0.GA:compile\n" +
                "[INFO] |  |  \\- com.taobao.trade:tradecomponent:jar:1.0.10:compile\n" +
                "[INFO] |  |     +- com.taobao.trade:tradespi:jar:1.2.5:compile\n" +
                "[INFO] |  |     |  +- net.sourceforge.findbugs:jsr305:jar:1.3.7:compile\n" +
                "[INFO] |  |     |  \\- com.alibaba.toolkit:toolkit-common-lang:jar:1.0:compile\n" +
                "[INFO] |  |     +- com.fasterxml.jackson.module:jackson-module-mrbean:jar:2.0.5:compile\n" +
                "[INFO] |  |     +- com.fasterxml.jackson.module:jackson-module-jaxb-annotations:jar:2.0.5:compile\n" +
                "[INFO] |  |     +- org.reflections:reflections:jar:0.9.9-RC1:compile\n" +
                "[INFO] |  |     |  \\- org.javassist:javassist:jar:3.16.1-GA:compile\n" +
                "[INFO] |  |     \\- com.alibaba.trade.proxy:method-invoke-proxy:jar:1.0.2-SNAPSHOT:compile\n" +
                "[INFO] |  +- com.alibaba.dw.shared:openapi-lib:jar:1.0.0-SNAPSHOT:compile\n" +
                "[INFO] |  +- com.alibaba:fastjson:jar:1.2.25:compile\n" +
                "[INFO] |  +- com.taobao.dgadmin:dgadmin-support:jar:0.0.3-SNAPSHOT:compile\n" +
                "[INFO] |  |  \\- com.taobao.tmallsearch:tmallsearch-client:jar:1.2.4-SNAPSHOT:compile\n" +
                "[INFO] |  +- com.taobao.promotioncenter:promotion-core-client:jar:4.9.2:compile\n" +
                "[INFO] |  |  +- com.taobao.common.tfs:tfs-client-restful:jar:1.2.9:compile\n" +
                "[INFO] |  |  +- com.taobao.terminator:terminator-client:jar:2.5.3:compile\n" +
                "[INFO] |  |  |  \\- oracle:oracle:jar:10.2.0.3.0:compile\n" +
                "[INFO] |  |  +- com.taobao.terminator:terminator-common:jar:2.6.0-SNAPSHOT:compile\n" +
                "[INFO] |  |  |  +- org.apache.solr:solr-core:jar:1.4.0:compile\n" +
                "[INFO] |  |  |  |  +- org.apache.solr:solr-solrj:jar:1.4.0:compile\n" +
                "[INFO] |  |  |  |  +- org.apache.lucene:lucene-analyzers:jar:2.9.1:compile\n" +
                "[INFO] |  |  |  |  |  \\- org.apache.lucene:lucene-core:jar:2.9.1:compile\n" +
                "[INFO] |  |  |  |  +- org.apache.lucene:lucene-highlighter:jar:2.9.1:compile\n" +
                "[INFO] |  |  |  |  +- org.apache.lucene:lucene-queries:jar:2.9.1:compile\n" +
                "[INFO] |  |  |  |  +- org.apache.lucene:lucene-snowball:jar:2.9.1:compile\n" +
                "[INFO] |  |  |  |  +- org.apache.lucene:lucene-memory:jar:2.9.1:compile\n" +
                "[INFO] |  |  |  |  +- org.apache.lucene:lucene-misc:jar:2.9.1:compile\n" +
                "[INFO] |  |  |  |  +- org.apache.lucene:lucene-spellchecker:jar:2.9.1:compile\n" +
                "[INFO] |  |  |  |  +- org.apache.solr:solr-commons-csv:jar:1.4.0:compile\n" +
                "[INFO] |  |  |  |  \\- woodstox:wstx-asl:jar:3.2.7:compile\n" +
                "[INFO] |  |  |  +- com.taobao.hsf:hsf.unit:jar:1.0.0:compile\n" +
                "[INFO] |  |  |  |  \\- com.taobao.remoting:network.service:jar:1.1.3:compile\n" +
                "[INFO] |  |  |  +- opensymphony:quartz:jar:1.6.0:compile\n" +
                "[INFO] |  |  |  \\- org.slf4j:log4j-over-slf4j:jar:1.5.10:compile\n" +
                "[INFO] |  |  +- apache-collections:commons-collections:jar:999-not-exist-v3:compile\n" +
                "[INFO] |  |  +- com.taobao.ump:ump-xmp-client:jar:3.8.7-coupon3-SNAPSHOT:compile\n" +
                "[INFO] |  |  |  \\- com.taobao.common.uic.uic-security:common-uic-security:jar:1.0.9:compile\n" +
                "[INFO] |  |  +- com.taobao.ump:ump-core-client:jar:3.8.7-coupon3-SNAPSHOT:compile\n" +
                "[INFO] |  |  +- com.taobao.ump.serializer:ump-serializer:jar:0.0.1-SNAPSHOT:compile\n" +
                "[INFO] |  |  |  \\- com.taobao.ump.protostuff:ump-protostuff:jar:0.0.1-SNAPSHOT:compile\n" +
                "[INFO] |  |  +- com.taobao.umptag:ump-tag-client:jar:1.1.2-wantong-SNAPSHOT:compile\n" +
                "[INFO] |  |  +- net.sf.ehcache:ehcache-core:jar:2.5.1:compile\n" +
                "[INFO] |  |  \\- com.alibaba.corrector:corrector-client:jar:1.0.0-SNAPSHOT:compile\n" +
                "[INFO] |  +- com.taobao.promotioncenter:promotion-common-client:jar:4.9.2:compile\n" +
                "[INFO] |  |  +- com.alibaba.toolkit.common.enum:enum:jar:1.0:compile\n" +
                "[INFO] |  |  +- com.alibaba.toolkit:toolkit-webx-all-in-one:jar:2.0.3:compile\n" +
                "[INFO] |  |  |  +- commons-configuration:commons-configuration:jar:1.6:compile\n" +
                "[INFO] |  |  |  +- commons-jexl:commons-jexl:jar:1.1:compile\n" +
                "[INFO] |  |  |  \\- org.freemarker:freemarker:jar:2.3.15:compile\n" +
                "[INFO] |  |  +- com.taobao.biz.tcp:tcp:jar:1.0:compile\n" +
                "[INFO] |  |  +- org.ow2.asm:asm:jar:5.0.3:compile\n" +
                "[INFO] |  |  +- com.taobao.top:top-userportal-client:jar:2.51-SNAPSHOT:compile\n" +
                "[INFO] |  |  |  +- com.taobao.top:top-tim-client:jar:2.62-omni-SNAPSHOT:compile\n" +
                "[INFO] |  |  |  |  +- com.taobao.top:topauth-client:jar:2.6-SNAPSHOT:compile\n" +
                "[INFO] |  |  |  |  \\- net.lingala.zip4j:zip4j:jar:1.3.2:compile\n" +
                "[INFO] |  |  |  +- com.alibaba.citrus.private:citrus-webx-compatible:jar:3.0.6:compile\n" +
                "[INFO] |  |  |  |  \\- com.alibaba.citrus:citrus-webx-all-in-one:jar:3.0.6:compile\n" +
                "[INFO] |  |  |  +- com.alibaba.external:sourceforge.ibatis:jar:2.3.4.726-patch2.0:compile (version managed from 2.3.0.677-patch2.0)\n" +
                "[INFO] |  |  |  +- com.taobao.top:top-service-util:jar:1.1.1-SNAPSHOT:compile\n" +
                "[INFO] |  |  |  |  \\- org.bouncycastle:bcmail-jdk16:jar:1.45:compile\n" +
                "[INFO] |  |  |  |     \\- org.bouncycastle:bcprov-jdk16:jar:1.45:compile\n" +
                "[INFO] |  |  |  +- com.taobao.top:top-service-common:jar:1.1.7-SNAPSHOT:compile\n" +
                "[INFO] |  |  |  |  +- com.taobao.top:top-monitor-client:jar:1.0.4:compile\n" +
                "[INFO] |  |  |  |  +- com.taobao.top:top-console-client:jar:1.1.6-SNAPSHOT:compile\n" +
                "[INFO] |  |  |  |  +- com.taobao.top:top-xbox:jar:1.17.2-SNAPSHOT:compile\n" +
                "[INFO] |  |  |  |  \\- com.taobao.fwspc:fwspc-client:jar:2.4.7:compile\n" +
                "[INFO] |  |  |  |     \\- com.taobao.top:top-service-domain:jar:2.4.27:compile\n" +
                "[INFO] |  |  |  +- com.taobao.top:top-autoapi-service:jar:1.0.67-mysql-SNAPSHOT:compile\n" +
                "[INFO] |  |  |  |  +- com.taobao.top:top-turbo:jar:1.0.43-SNAPSHOT:compile\n" +
                "[INFO] |  |  |  |  +- com.taobao.top:tasp-client:jar:1.7-mysql-SNAPSHOT:compile\n" +
                "[INFO] |  |  |  |  \\- com.taobao.top:tasp-domain:jar:1.7-mysql-SNAPSHOT:compile\n" +
                "[INFO] |  |  |  \\- com.taobao.top:top-autoapi-domain:jar:1.0.8.2-mysql-SNAPSHOT:compile\n" +
                "[INFO] |  |  +- com.alibaba.toolkit.common.convert:convert:jar:1.0:compile\n" +
                "[INFO] |  |  +- org.apache.hadoop:hadoop-core:jar:0.20.2-cdh3u3:compile\n" +
                "[INFO] |  |  +- org.apache.hadoop.thirdparty.guava:guava:jar:r09-jarjar:compile\n" +
                "[INFO] |  |  +- org.apache.directory.studio:org.apache.commons.logging:jar:1.1.1:compile\n" +
                "[INFO] |  |  +- com.taobao.ump:promotion-limit-client:jar:1.0.4-SNAPSHOT:compile\n" +
                "[INFO] |  |  |  \\- com.taobao.tddl:tddl-client:jar:3.3.2.4:compile\n" +
                "[INFO] |  |  |     +- com.taobao.tddl:tddl-common:jar:3.3.2.4:compile\n" +
                "[INFO] |  |  |     |  \\- com.taobao.tddl:tddl-interact:jar:3.3.2.4:compile\n" +
                "[INFO] |  |  |     +- com.taobao.tddl:tddl-rule:jar:3.3.2.4:compile\n" +
                "[INFO] |  |  |     +- com.taobao.tddl:tddl-parser:jar:3.3.2.4:compile\n" +
                "[INFO] |  |  |     |  \\- org.antlr:antlr:jar:3.1.3:compile\n" +
                "[INFO] |  |  |     +- com.taobao.tddl:tddl-mysql-parser:jar:3.3.2.4:compile\n" +
                "[INFO] |  |  |     +- com.taobao.tddl:tddl-group-datasource:jar:3.3.2.4:compile\n" +
                "[INFO] |  |  |     |  \\- commons-dbcp:commons-dbcp:jar:1.2.2:compile\n" +
                "[INFO] |  |  |     +- com.taobao.tddl:tddl-druid-datasource:jar:3.3.2.4:compile\n" +
                "[INFO] |  |  |     |  \\- com.oracle:ojdbc14:jar:10.2.0.3.0:compile\n" +
                "[INFO] |  |  |     \\- com.taobao.tddl:tddl-rule-le:jar:3.3.2.4:compile\n" +
                "[INFO] |  |  +- com.taobao.pamirspromotion:pamirspromotion-client:jar:2.0.2-benefitcenter-SNAPSHOT:compile\n" +
                "[INFO] |  |  |  +- com.taobao.pamirspromotion:pamirspromotion-common:jar:2.0.2-benefitcenter-SNAPSHOT:compile\n" +
                "[INFO] |  |  |  \\- org.apache.commons:commons-collections4:jar:4.1:compile\n" +
                "[INFO] |  |  \\- com.aliyun.opensearch:aliyun-sdk-opensearch:jar:3.0.8:compile\n" +
                "[INFO] |  |     \\- org.apache.httpcomponents:httpmime:jar:4.3.1:compile\n" +
                "[INFO] |  +- org.springframework:spring:jar:999-not-exist:compile\n" +
                "[INFO] |  +- com.alibaba.citrus:citrus-webx-all:jar:3.3.1-s:compile\n" +
                "[INFO] |  |  +- org.apache.commons:commons-jexl:jar:2.1.1:compile\n" +
                "[INFO] |  |  +- aopalliance:aopalliance:jar:1.0:compile\n" +
                "[INFO] |  |  +- org.springframework:spring-web:jar:4.2.4.RELEASE:compile\n" +
                "[INFO] |  |  \\- org.springframework:spring-webmvc:jar:3.1.2.RELEASE:compile\n" +
                "[INFO] |  +- com.alibaba.idst:nls-service-sdk:jar:3.2.4:compile\n" +
                "[INFO] |  |  \\- com.google.gson:gson:jar:2.2.4:compile\n" +
                "[INFO] |  +- io.netty:netty:jar:3.7.0.Final:compile\n" +
                "[INFO] |  +- org.springframework:spring-beans:jar:3.1.2.RELEASE:compile\n" +
                "[INFO] |  +- org.springframework:spring-ibatis:jar:2.0.8:compile\n" +
                "[INFO] |  |  \\- org.apache.ibatis:ibatis-sqlmap:jar:2.3.0:compile\n" +
                "[INFO] |  +- org.codehaus.groovy:groovy-all:jar:2.0.5:compile\n" +
                "[INFO] |  +- groovy:groovy-all:jar:999-not-exist-v3:compile\n" +
                "[INFO] |  \\- com.alibaba.dts:dts-client:jar:1.0.4.6:compile\n" +
                "[INFO] |     +- com.alibaba.dts:dts-common:jar:1.0.4.6:compile\n" +
                "[INFO] |     |  +- org.apache.zookeeper:zookeeper:jar:3.4.5-alibaba-1.1.0:compile\n" +
                "[INFO] |     |  \\- org.apache.curator:curator-recipes:jar:2.5.0:compile\n" +
                "[INFO] |     |     \\- org.apache.curator:curator-framework:jar:2.5.0:compile\n" +
                "[INFO] |     |        \\- org.apache.curator:curator-client:jar:2.5.0:compile\n" +
                "[INFO] |     \\- com.alibaba.tmq:tmq-common:jar:0.0.4-SNAPSHOT:compile\n" +
                "[INFO] |        +- org.ini4j:ini4j:jar:0.5.2:compile\n" +
                "[INFO] |        +- org.jodd:jodd:jar:3.3.8:compile\n" +
                "[INFO] |        \\- quartz-all:quartz-all:jar:1.6.3:compile";

        StringReader sr = new StringReader(dep);
        BufferedReader br = new BufferedReader(sr);
        String line ;
        int i = 0;
        while ((line = br.readLine())!=null){
            if(line.startsWith("[INFO] |  +-")){
                int a = line.indexOf("+-");
                int b = line.indexOf(":",0);
                int c = line.indexOf(":",b+1);
                System.out.println("<exclusion>");
                System.out.println("<groupId>"+line.substring(a+3,b)+"</groupId>");
                System.out.println("<artifactId>"+line.substring(b+1,c)+"</artifactId>");
                System.out.println("</exclusion>");
                i++;
            }
        }
        System.out.println("¹²ÅÅ³ý"+i+"¸öÒÀÀµ");
    }



}
