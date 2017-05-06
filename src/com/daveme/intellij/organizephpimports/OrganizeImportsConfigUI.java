package com.daveme.intellij.organizephpimports;

import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class OrganizeImportsConfigUI implements SearchableConfigurable {
    private Project project;
    private boolean modified;

    private JCheckBox addAnExtraBackslashCheckBox;
    private JPanel myPanel;
    private JCheckBox removeUnusedUseStatementsCheckBox;
    private JCheckBox sortUseStatementsCheckBox;

    OrganizeImportsConfigUI(@NotNull Project project) {
        this.project = project;
    }

    public void loadSettings(Settings settings) {
        addAnExtraBackslashCheckBox.setSelected(settings.addAnExtraBackslashCheckBox);
        removeUnusedUseStatementsCheckBox.setSelected(settings.removeUnusedUseStatementsCheckBox);
        sortUseStatementsCheckBox.setSelected(settings.sortUseStatementsCheckBox);
    }

    public void saveSettings(Settings settings) {
        settings.addAnExtraBackslashCheckBox = addAnExtraBackslashCheckBox.isSelected();
        settings.removeUnusedUseStatementsCheckBox = removeUnusedUseStatementsCheckBox.isSelected();
        settings.sortUseStatementsCheckBox = sortUseStatementsCheckBox.isSelected();
    }

    @NotNull
    @Override
    public String getId() {
        return "organizephpimports.OrganizeImportsConfigUI";
    }

    @Nullable
    @Override
    public Runnable enableSearch(String s) {
        return null;
    }

    @Nls
    @Override
    public String getDisplayName() {
        return null;
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return null;
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        Settings settings = Settings.getInstance(project);
        loadSettings(settings);
        modified = true;
        return myPanel;
    }

    @Override
    public boolean isModified() {
        return modified;
    }

    @Override
    public void apply() throws ConfigurationException {
        Settings settings = Settings.getInstance(project);
        saveSettings(settings);
        modified = false;
    }

    @Override
    public void reset() {

    }

    @Override
    public void disposeUIResources() {

    }
}
