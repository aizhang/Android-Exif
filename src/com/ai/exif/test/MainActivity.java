package com.ai.exif.test;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;

import com.ai.exif.ExifInterface;

public class MainActivity extends  Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	
	
	public static void writeExif(ExifInterface exif, final String dstFilename) throws IOException {
		if (null == exif)
			return;
		// create a backup file
		File dst_file = new File(dstFilename);
		File bak_file = new File(dstFilename + ".t");

		// try to delete old copy of backup
		bak_file.delete();

		// rename dst file into backup file
		// Log.d( TAG, "rename dst into bak" )
		// if( ! dst_file.renameTo( bak_file ) ) return;

		try {
			// Log.d( TAG, "try to write into dst" );
			// writeExif( bak_file.getAbsolutePath(), dst_file.getAbsolutePath()
			// );

			// Trying to write into bak_file using dst_file as source
			exif.writeExif(dst_file.getAbsolutePath(), bak_file.getAbsolutePath());

			// Now switch bak into dst
			bak_file.renameTo(dst_file);
		} catch (IOException e) {
			throw e;
		} finally {
			// deleting backup file
			bak_file.delete();
		}
	}
	
}
