#!/usr/bin/env python3
"""
calc_dist_station

Usage:
	calc_dist_station.py langitude longitude (in float)
"""

import json
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
			with open('distances.json', 'w') as f:
				json.dump(sorted_stations, f)
	else: exit()


def main():
	"""reads the CLI-Arguments
	"""
	calc_dist(sys.argv[1:])


if __name__ == '__main__':
	main()
