package axj.ap.dao;

import axj.ap.entity.comment.TComment;
import axj.ap.entity.comment.TReply;
import axj.db.OSess;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CmtDao {
    public static List<TComment> getCommentList(String cmtType, String cmtObjId) {
        List<TComment> commentList = new CopyOnWriteArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try {
            commentList = sess.getAdl().list(
                    TComment.class, sess.conn(),
                    "select * from TComment where cmtType = ? and cmtObjId = ? order by timestamp desc",
                    new String[]{cmtType, cmtObjId}
            );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }
        return commentList;
    }

    public static List<TReply> getReplicationList(String[] cmtId) {
        List<TReply> replyList = new CopyOnWriteArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try {
            replyList = sess.getAdl().list(
                    TReply.class, sess.conn(),
                    "SELECT r.* FROM TReply r INNER JOIN TComment c ON (r.commentId = c.id and r.commentId in (?))",
                    cmtId
            );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }
        return replyList;
    }
}
