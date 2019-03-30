<heroes>
	<#list heroes as hero>
	<hero>
		<name>${hero.name}</name>
		<location>${hero.location}</location>
		<quote>${hero.quote}</quote>
		<data>${hero.date?date}</data>
	</hero>
	</#list>
</heroes>