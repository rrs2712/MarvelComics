package com.appbusiness.marvelcomics.ui.main;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by rrs27 on 2017-12-05.
 */

public class MainTest {

    private MainView mainView;
    private MainPresenter mainPresenter;

    /**
     * Check if {@link MainView} is implementing {@link IComic.View}
     */
    @Test
    public void testMainView(){
        mainView= new MainView();
        assertTrue(mainView instanceof IComic.View);
    }

    /**
     * Check if {@link MainPresenter} is implementing {@link IComic.Presenter}
     */
    @Test
    public void testMainPresenter(){
        mainPresenter = new MainPresenter(mainView);
        assertTrue(mainPresenter instanceof IComic.Presenter);
    }

    /**
     * Check if {@link MainModel} is implementing {@link IComic.Model}
     */
    @Test
    public void testMainModel(){
        MainModel mainModel = new MainModel(mainPresenter);
        assertTrue(mainModel instanceof IComic.Model);
    }
}
