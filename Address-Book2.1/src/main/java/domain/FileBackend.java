package domain;

public class FileBackend implements Backend {
		String path;

		public FileBackend(String path2) {
			this.path=path2;
		}

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

		public String toString() {
			return path;
		}
		
}
