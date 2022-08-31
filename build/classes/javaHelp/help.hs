<?xml version="1.0" encoding='ISO-8859-1' ?>
<!DOCTYPE helpset PUBLIC "-//Sun Microsystems Inc.//DTD JavaHelp HelpSet Version 1.0//EN" "http://java.sun.com/products/javahelp/helpset_1_0.dtd">
<helpset version="1.0">
    <title>Manual de uso</title>
    <maps>

        <homeID>manual</homeID>

        <mapref location="map.jhm"/>
    </maps>

    <view>
        <name>Tabla Contidos</name>
        <label>Tabla de contidos</label>
        <type>javax.help.TOCView</type>
        <data>tablacontidos.xml</data>
    </view>
    <view>
        <name>Indice</name>
        <label>O indice</label>
        <type>javax.help.IndexView</type>
        <data>index.xml</data>
    </view>
    <view>
        <name>Buscar</name>
        <label>Buscar</label>
        <type>javax.help.SearchView</type>
        <data engine="com.sun.java.help.search.DefaultSearchEngine">
             JavaHelpSearch
        </data>
    </view>
</helpset>
