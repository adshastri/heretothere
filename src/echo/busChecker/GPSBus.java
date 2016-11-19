package minecrafthelper;

import java.util.Arrays;
import java.util.List;

public class GPSBus {

	List<String> places = Arrays.asList(
		"Rutgers Academic Building",
		"Allison Road Classroom",
		"Art History Hall",
		"Beck Hall",
		"Bishop House",
		"Biological Sciences",
		"Blake Hall",
		"Biomedical Engineering Building",
		"Business Rockafeller Road",
		"Bartlett Hall",
		"Campbell Hall",
		"Cook Douglass Lecture Hall",
		"School of Communication and Information",
		"Civic Square",
		"Davison Hall",
		"Graduate School of Education",
		"Engineering Building",
		"Environmental & Natural Resources Sciences Building",
		"Floricultural Greenhouse",
		"Frelinghuysen Hall",
		"Foran Hall",
		"Food Science Building",
		"Honors College",
		"Hickman Hall",
		"Hardenbergh Hall",
		"Hill Center",
		"Heldrich Science Building",
		"Janice H. Levin Building",
		"Kathleen W. Ludwig Global Village Learning Center",
		"Labor Education Center",
		"Lipman Hall",
		"Loree Classroom Building",
		"Lucy Stone Hall",
		"Lucy Stone Hall Auditorium",
		"Milledoler Hall",
		"Murray Hall",
		"Marryott Music Building, Stephanie Morris",
		"Pharmacy Building (William Levin Hall)",
		"Physics Lecture Hall",
		"Ruth Adams Building",
		"Rutgers Cinema",
		"Ruth Dill Johnson Crockett Building",
		"Rehearsal Hall – Douglass",
		"Robert E. Mortensen Hall",
		"Scott Hall",
		"Science & Engineering Resource Center",
		"Serin Physics Building",
		"Thompson Hall",
		"Tillett Hall",
		"Van Dyck Hall",
		"Voorhees Hall",
		"Waller Hall",
		"Wright Rieman Laboratories",
		"May Duff Walters Hall",
		"Zimmerli Art Museum");

	List<Integer> buildingNums = Arrays.asList(
3198,
3878,
8428,
4145,
3049,
8304,
6005,
3893,
4181,
6024,
3121,
8840,
3134,
3158,
8322,
3037,
3558,
6330,
6002,
3117,
6347,
6246,
3197,
8311,
3119,
3752,
8302,
4163,
8444,
6109,
6025,
8432,
4153,
4153,
3010,
3011,
8310,
3863,
3562,
8303,
4178,
8309,
8422,
8443,
3038,
3854,
3561,
6004,
4146,
3016,
3013,
6000,
3556,
8419,
3013);  

	public int getID(String s){
		int i = places.indexOf(s);
		if(i == -1)
			return -1;
		else
			return buildingNums.get(i);

	}

	public boolean contains(String s){
		for(String a: places){
			if(s.equals(a.toLowerCase()))
				return true;
		}

		return false;	
		//return places.contains(s);

	}



}