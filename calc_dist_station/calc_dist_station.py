#!/usr/bin/env python3
"""
calc_dist_station

Usage:
	calc_dist_station.py langitude longitude (in float)
"""
import io
import json      #want to write a json file
import functools
import sys
from geopy.geocoders import Nominatim
geolocator = Nominatim()
from geopy.distance import vincenty

def calc_dist(args):
	""" reads the rnvstations.json and calculates the distance to the
		provided geolocation.
	"""
	location = geolocator.reverse(args[0] + ", " + args[1])
	print("is: " + location.address + " correct? \n")
	x = input("[Y]es [N]o\n")
	if x == "y":
		print("calculating distances")
		with open('rnvstations.json') as data_file:    
			stations = json.load(data_file)
			for station in stations:
				station['distance'] = vincenty(args[0] + ", " + args[1], station["latitude"] + ", " + station["longitude"]).km
			sorted_stations = sorted(stations, key=lambda k: k['distance']) 
			with io.open('distances.json', 'w', encoding='utf8') as outfile:
				json.dump(sorted_stations, outfile, ensure_ascii=False)
	else: exit()


def main():
	"""reads the CLI-Arguments
	"""
	if len(sys.argv)<3: 
		print("Usage:  calc_dist_station.py langitude longitude (in float)")
		exit()
	calc_dist(sys.argv[1:])


if __name__ == '__main__':
	main()
