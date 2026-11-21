package interface_adapter.navigation;

import interface_adapter.ViewManagerModel;

public class ViewManagerSwitcher implements ViewSwitcher {

    private final ViewManagerModel viewManagerModel;

    public ViewManagerSwitcher(ViewManagerModel viewManagerModel) {
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void switchTo(String viewName) {
        viewManagerModel.setState(viewName);
        viewManagerModel.notifyViewChanged();
    }
}
