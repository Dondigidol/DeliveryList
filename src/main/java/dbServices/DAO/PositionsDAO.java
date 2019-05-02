package dbServices.DAO;

import dbServices.dataSets.Position;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class PositionsDAO {
    private Session session;

    public PositionsDAO(Session session){
        this.session = session;
    }

    public void savePosition(Position position) throws HibernateException {
        session.save(position);
    }


}
