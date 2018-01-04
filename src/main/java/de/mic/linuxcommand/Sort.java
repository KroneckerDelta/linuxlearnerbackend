package de.mic.linuxcommand;

import org.unix4j.Unix4j;
import org.unix4j.unix.sort.SortOption;
import org.unix4j.unix.sort.SortOptions;

import de.mic.linuxlearner.service.LinuxCommandModel;

public class Sort extends LinuxCommandImpl implements LinuxCommand
{

    public Sort(LinuxCommandModel model)
    {
        super(model);
    }

    @Override
    public String execute()
    {
        String options = model.getSchalter();
        String source = model.getSource();

        if (options == null)
        {
            return Unix4j.fromString(source).sort().toStringResult();
        }
        else
        {
            return Unix4j.fromString(source).sort(extractOption(options)).toStringResult();
        }
    }

    private SortOptions extractOption(String option)
    {
        switch (option)
        {
            case "check":
                return SortOption.check;
            case "dictionaryOrder":
                return SortOption.dictionaryOrder;
            case "generalNumericSort":
                return SortOption.generalNumericSort;
            case "humanNumericSort":
                return SortOption.humanNumericSort;
            case "ignoreCase":
                return SortOption.ignoreCase;
            case "ignoreLeadingBlanks":
                return SortOption.ignoreLeadingBlanks;
            case "merge":
                return SortOption.merge;
            case "monthSort":
                return SortOption.monthSort;
            case "numericSort":
                return SortOption.numericSort;
            case "reverse":
                return SortOption.reverse;
            case "unique":
                return SortOption.unique;
            case "versionSort":
                return SortOption.versionSort;

            default:
                break;
        }
        return null;
    }

}
