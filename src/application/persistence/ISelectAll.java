package application.persistence;

import java.util.List;

public interface ISelectAll<T> {

    List<T> selectAll();
}
