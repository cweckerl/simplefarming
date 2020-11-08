# -*- coding: utf-8 -*-
import re

with open('FoodTier.java', 'r') as file, open ('declare', 'w') as output1, open('hunger_values', 'w') as output2, open('init', 'w') as output3:
	content = file.readlines()

	key = 'public static final Food'
	replace = 'public static ForgeConfigSpec.IntValue'
	
	for line in content:
		if key in line:
			output1.write(line.lower().split(' =', 1)[0].replace("\t" + key.lower(), replace) + ";\n")
	for line in content:
		if key in line:
			raw = map(int, re.findall('\d+', line))
			num_list = list(raw)
			
			food = line.lower().replace("\t" + key.lower() + " ", "").split('=', 1)[0]
			
			output2.write('%s= config.defineInRange("%s(default = %d)", %d, 0, Integer.MAX_VALUE);\n' %(food, food, num_list[0], num_list[0]))
			
			pos_i = line.find('.hunger')
			pos_f = line.find('.saturation')
			output3.write(line.replace(line[pos_i : pos_f], ".hunger(HungerConfig.%s.get())" %food.replace(" ", "")) )
			