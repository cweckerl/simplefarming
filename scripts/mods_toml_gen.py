# -*- coding: utf-8 -*-
"""
author: cweckerl
"""
mcVersion = input("Input Minecraft version -> ")
modVersion = input("Input mod version -> ")

with open('mods.toml', 'w') as file:
	file.write('modLoader="javafml"\n')
	if mcVersion == '1.16.3':
		loaderVersion = 34
	elif mcVersion == '1.16.2':
		loaderVersion = 33
	elif mcVersion == '1.16.1':
		loaderVersion = 32
	elif mcVersion == '1.15.2':
		loaderVersion = 31
	else:
		loaderVersion = int(input("Unable to find mod loader version. Please enter value manually -> "))
	file.write('loaderVersion="[%d,)"\n' %loaderVersion)
	if loaderVersion > 31:
		file.write('license="MIT"\n')
	file.write('issueTrackerURL="https://github.com/cweckerl/simplefarming/issues"\n')
	file.write('version="%s-%s"\n' %(mcVersion, modVersion))
	file.write('displayName="Simple Farming"\ndisplayURL="https://www.curseforge.com/minecraft/mc-mods/simple-farming"\nauthors="enemeez"\n')
	file.write("description='''Extends the farming system with more fruits, vegetables, and meals.'''\n")
	file.write ('\n[[dependencies.examplemod]]\nmodId="forge"\nmandatory=true\nversionRange="[%d,)"\nordering="NONE"\nside="BOTH"\n\n[[dependencies.examplemod]]\nmodId="minecraft"\nmandatory=true\nversionRange="[%s]"\nordering="NONE"\nside="BOTH"\n' %(loaderVersion, mcVersion))