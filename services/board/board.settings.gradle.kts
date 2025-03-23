val board = rootDir
    .resolve("services")
    .resolve("board")  // "board" 폴더 기준으로 시작
    .walkTopDown()     // 최상위부터 하위 디렉토리까지 탐색
    .maxDepth(5)       // 탐색 깊이 제한
    .filter(File::isDirectory)  // 디렉토리만 필터링
    .associateBy { it.relativeTo(rootDir).path } // 디렉토리 이름을 Key로 하고, File 객체를 Value로 하는 Map 생성


include(
    "board",

    // "board" 모듈의 하위 모듈로 관리
    "board:application",
    "board:board",
    "board:board:board-domain",
    "board:board:board-domain-driven"
)

project(":board").projectDir = board["services/board"]!!
project(":board:application").projectDir = board["services/board/application"]!!

project(":board:board").projectDir = board["services/board/board"]!!
project(":board:board:board-domain").projectDir = board["services/board/board/board-domain"]!!
project(":board:board:board-domain-driven").projectDir = board["services/board/board/board-domain-driven"]!!