package menutree;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class NodesForMenu {
	private String line = null;
	private List<String> linesMenuText = new ArrayList<String>();

	public NodesForMenu() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("src/res/MenuText"));
		while ((line = reader.readLine()) != null) {
			linesMenuText.add(line);
		}
		reader.close();
	}

	public TreeForMenu generateMenuNodes() throws Exception {
		TreeForMenu tfm = new TreeForMenu();
		for (int i = 0; i < linesMenuText.size(); i++) {

			String line = linesMenuText.get(i);

			if (line.length() != 0) {

				String[] linePartsSplitedByDD = line.split(":");
				tfm.currentNode = tfm.getRootNode();
				String[] level = linePartsSplitedByDD[0].split(Pattern.quote("."));
				if (level.length == 1) {
					tfm.currentNode.addChildNode(Integer.parseInt(level[0]), new Node<String>(linePartsSplitedByDD[1]));
				} else {
					String[] level_1 = new String[level.length - 1];
					for (int r = 0; r < level_1.length; r++) {
						level_1[r] = level[r];
					}
					if (tfm.isValidPath(level_1)
							&& !tfm.currentNode.getChildren().values().contains(linePartsSplitedByDD[1])) {
						for (int k = 0; k < level_1.length; k++) {
							tfm.currentNode = tfm.currentNode.getChildNode(Integer.parseInt(level_1[k]));
						}
						tfm.currentNode.addChildNode(Integer.parseInt(level[level.length - 1]),
								new Node<String>(linePartsSplitedByDD[1]));
					}
				}
			}
		}
		return tfm;
	}
}