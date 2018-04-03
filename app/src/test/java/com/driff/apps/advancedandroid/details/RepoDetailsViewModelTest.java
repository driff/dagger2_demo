package com.driff.apps.advancedandroid.details;

import com.driff.apps.advancedandroid.model.Repo;
import com.driff.apps.advancedandroid.testutils.TestUtils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RepoDetailsViewModelTest {

    private RepoDetailsViewModel viewModel;

    private Repo repo = TestUtils.loadJson("mock/get_repo.json", Repo.class);
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void details() {
    }

    @Test
    public void contributors() {
    }

    @Test
    public void detailsError() {
    }

    @Test
    public void contributorsError() {
    }
}