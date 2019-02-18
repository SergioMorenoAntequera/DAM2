<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:template match="/">
		<html>
			<head>
				<title>
					Practica01.Acceso a datos
				</title>
			</head>
			<body>
				<h2>Departamentos</h2>
				<ul style="list-style:none;">
					<xsl:for-each select="Departamentos/departamento">
					<xsl:sort data-type="text" order="ascending"/>
						<li><strong>id: </strong><xsl:value-of select="id"/></li>
						<li><strong>tipo: </strong><xsl:value-of select="tipo"/></li>
						<li><strong>nombre: </strong><xsl:value-of select="nombre"/></li>
						<li><strong>domicilio: </strong><xsl:value-of select="domicilio"/></li>
						<li><strong>ciudad: </strong><xsl:value-of select="ciudad"/></li>
						<li><strong>cp: </strong><xsl:value-of select="cp"/></li>
						<li><strong>provincia: </strong><xsl:value-of select="provincia"/></li>
						<li><strong>pais: </strong><xsl:value-of select="pais"/></li>
						<br/>
					</xsl:for-each>
				</ul>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>