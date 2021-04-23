package servlet.gcs;

import java.net.MalformedURLException;
import java.util.ArrayList;

import tools.gcs.Photo;

public class Sample {
	public static ArrayList<Photo> getPhotoSamples() {
		ArrayList<Photo> samples = new ArrayList<Photo>();
		
		String[] urls = {
				"https://storage.cloud.google.com/test-eclipse-tools.appspot.com/temp/Sketchpad.png",
				"https://storage.cloud.google.com/test-eclipse-tools.appspot.com/temp/IMG_20160319_084342.jpg",
				"https://storage.cloud.google.com/test-eclipse-tools.appspot.com/temp/IMG_20160321_133943.jpg"
		};
		int likes = 10;
		String[] _comments = {
				"comment 1",
				"comment 2",
				"comment 3"
			};
		ArrayList<String> comments = new ArrayList<String>();
		for (String c : _comments) {
			comments.add(c);
		}
		for (String url : urls) {
			try {
				Photo photo = new Photo(url, comments, likes);
				samples.add(photo);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return samples;
	}
}
