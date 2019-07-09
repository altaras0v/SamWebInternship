package myapp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author www.luv2code.com
 *
 */
public class testReadFileFromDB {

    public static void main(String[] args) throws Exception {

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        InputStream input = null;
        FileOutputStream output = null;

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/elearning?characterEncoding=utf8&useConfigs=maxPerformance&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin");


            // 2. Execute statement
            myStmt = myConn.createStatement();
            String sql = "select file from test where id='1'";
            myRs = myStmt.executeQuery(sql);

            // 3. Set up a handle to the file
            File theFile = new File("C:\\Files\\paradrop.png");
            output = new FileOutputStream(theFile);

            if (myRs.next()) {

                input = myRs.getBinaryStream("file");
                System.out.println("Reading resume from database...");
                System.out.println(sql);

                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    output.write(buffer);
                }

                System.out.println("\nSaved to file: " + theFile.getAbsolutePath());

                System.out.println("\nCompleted successfully!");
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (input != null) {
                input.close();
            }

            if (output != null) {
                output.close();
            }

            close(myConn, myStmt);
        }
    }

    private static void close(Connection myConn, Statement myStmt)
            throws SQLException {

        if (myStmt != null) {
            myStmt.close();
        }

        if (myConn != null) {
            myConn.close();
        }
    }
}