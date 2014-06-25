package org.librucha.lamer.storage;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class DatabaseConfigUtil extends OrmLiteConfigUtil {

  public static void main(String[] args) throws SQLException, IOException {
	writeConfigFile(new File("src/main/res/raw", "ormlite_config.txt"));
  }
}