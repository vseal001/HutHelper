package cn.nicolite.huthelper.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import cn.nicolite.huthelper.model.bean.User;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USER".
*/
public class UserDao extends AbstractDao<User, String> {

    public static final String TABLENAME = "USER";

    /**
     * Properties of entity User.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property User_id = new Property(0, String.class, "user_id", true, "USER_ID");
        public final static Property StudentKH = new Property(1, String.class, "studentKH", false, "STUDENT_KH");
        public final static Property School = new Property(2, String.class, "school", false, "SCHOOL");
        public final static Property TrueName = new Property(3, String.class, "TrueName", false, "TRUE_NAME");
        public final static Property Username = new Property(4, String.class, "username", false, "USERNAME");
        public final static Property Dep_name = new Property(5, String.class, "dep_name", false, "DEP_NAME");
        public final static Property Class_name = new Property(6, String.class, "class_name", false, "CLASS_NAME");
        public final static Property Address = new Property(7, String.class, "address", false, "ADDRESS");
        public final static Property Active = new Property(8, String.class, "active", false, "ACTIVE");
        public final static Property Login_cnt = new Property(9, String.class, "login_cnt", false, "LOGIN_CNT");
        public final static Property Head_pic = new Property(10, String.class, "head_pic", false, "HEAD_PIC");
        public final static Property Last_login = new Property(11, String.class, "last_login", false, "LAST_LOGIN");
        public final static Property Sex = new Property(12, String.class, "sex", false, "SEX");
        public final static Property Head_pic_thumb = new Property(13, String.class, "head_pic_thumb", false, "HEAD_PIC_THUMB");
        public final static Property Bio = new Property(14, String.class, "bio", false, "BIO");
    }


    public UserDao(DaoConfig config) {
        super(config);
    }
    
    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USER\" (" + //
                "\"USER_ID\" TEXT PRIMARY KEY NOT NULL ," + // 0: user_id
                "\"STUDENT_KH\" TEXT," + // 1: studentKH
                "\"SCHOOL\" TEXT," + // 2: school
                "\"TRUE_NAME\" TEXT," + // 3: TrueName
                "\"USERNAME\" TEXT," + // 4: username
                "\"DEP_NAME\" TEXT," + // 5: dep_name
                "\"CLASS_NAME\" TEXT," + // 6: class_name
                "\"ADDRESS\" TEXT," + // 7: address
                "\"ACTIVE\" TEXT," + // 8: active
                "\"LOGIN_CNT\" TEXT," + // 9: login_cnt
                "\"HEAD_PIC\" TEXT," + // 10: head_pic
                "\"LAST_LOGIN\" TEXT," + // 11: last_login
                "\"SEX\" TEXT," + // 12: sex
                "\"HEAD_PIC_THUMB\" TEXT," + // 13: head_pic_thumb
                "\"BIO\" TEXT);"); // 14: bio
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, User entity) {
        stmt.clearBindings();
 
        String user_id = entity.getUser_id();
        if (user_id != null) {
            stmt.bindString(1, user_id);
        }
 
        String studentKH = entity.getStudentKH();
        if (studentKH != null) {
            stmt.bindString(2, studentKH);
        }
 
        String school = entity.getSchool();
        if (school != null) {
            stmt.bindString(3, school);
        }
 
        String TrueName = entity.getTrueName();
        if (TrueName != null) {
            stmt.bindString(4, TrueName);
        }
 
        String username = entity.getUsername();
        if (username != null) {
            stmt.bindString(5, username);
        }
 
        String dep_name = entity.getDep_name();
        if (dep_name != null) {
            stmt.bindString(6, dep_name);
        }
 
        String class_name = entity.getClass_name();
        if (class_name != null) {
            stmt.bindString(7, class_name);
        }
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(8, address);
        }
 
        String active = entity.getActive();
        if (active != null) {
            stmt.bindString(9, active);
        }
 
        String login_cnt = entity.getLogin_cnt();
        if (login_cnt != null) {
            stmt.bindString(10, login_cnt);
        }
 
        String head_pic = entity.getHead_pic();
        if (head_pic != null) {
            stmt.bindString(11, head_pic);
        }
 
        String last_login = entity.getLast_login();
        if (last_login != null) {
            stmt.bindString(12, last_login);
        }
 
        String sex = entity.getSex();
        if (sex != null) {
            stmt.bindString(13, sex);
        }
 
        String head_pic_thumb = entity.getHead_pic_thumb();
        if (head_pic_thumb != null) {
            stmt.bindString(14, head_pic_thumb);
        }
 
        String bio = entity.getBio();
        if (bio != null) {
            stmt.bindString(15, bio);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, User entity) {
        stmt.clearBindings();
 
        String user_id = entity.getUser_id();
        if (user_id != null) {
            stmt.bindString(1, user_id);
        }
 
        String studentKH = entity.getStudentKH();
        if (studentKH != null) {
            stmt.bindString(2, studentKH);
        }
 
        String school = entity.getSchool();
        if (school != null) {
            stmt.bindString(3, school);
        }
 
        String TrueName = entity.getTrueName();
        if (TrueName != null) {
            stmt.bindString(4, TrueName);
        }
 
        String username = entity.getUsername();
        if (username != null) {
            stmt.bindString(5, username);
        }
 
        String dep_name = entity.getDep_name();
        if (dep_name != null) {
            stmt.bindString(6, dep_name);
        }
 
        String class_name = entity.getClass_name();
        if (class_name != null) {
            stmt.bindString(7, class_name);
        }
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(8, address);
        }
 
        String active = entity.getActive();
        if (active != null) {
            stmt.bindString(9, active);
        }
 
        String login_cnt = entity.getLogin_cnt();
        if (login_cnt != null) {
            stmt.bindString(10, login_cnt);
        }
 
        String head_pic = entity.getHead_pic();
        if (head_pic != null) {
            stmt.bindString(11, head_pic);
        }
 
        String last_login = entity.getLast_login();
        if (last_login != null) {
            stmt.bindString(12, last_login);
        }
 
        String sex = entity.getSex();
        if (sex != null) {
            stmt.bindString(13, sex);
        }
 
        String head_pic_thumb = entity.getHead_pic_thumb();
        if (head_pic_thumb != null) {
            stmt.bindString(14, head_pic_thumb);
        }
 
        String bio = entity.getBio();
        if (bio != null) {
            stmt.bindString(15, bio);
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public User readEntity(Cursor cursor, int offset) {
        User entity = new User( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // user_id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // studentKH
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // school
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // TrueName
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // username
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // dep_name
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // class_name
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // address
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // active
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // login_cnt
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // head_pic
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // last_login
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // sex
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // head_pic_thumb
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14) // bio
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, User entity, int offset) {
        entity.setUser_id(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setStudentKH(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setSchool(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setTrueName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setUsername(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setDep_name(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setClass_name(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setAddress(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setActive(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setLogin_cnt(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setHead_pic(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setLast_login(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setSex(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setHead_pic_thumb(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setBio(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
     }
    
    @Override
    protected final String updateKeyAfterInsert(User entity, long rowId) {
        return entity.getUser_id();
    }
    
    @Override
    public String getKey(User entity) {
        if(entity != null) {
            return entity.getUser_id();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(User entity) {
        return entity.getUser_id() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
