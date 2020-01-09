package orderapp.model;

import java.util.List;

public interface DataObserver<TData> {

    void onChangedData(List<TData> data);
}
