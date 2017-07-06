import com.google.copybara.Destination.Reader;

  @Test
  public void testMapReferences() throws Exception {
    Files.write(workdir.resolve("test.txt"), "one".getBytes());
    process(firstCommitWriter(), new DummyRevision("1"));

    Files.write(workdir.resolve("test.txt"), "two".getBytes());
    GitDestination destination = destination();
    Writer writer = destination.newWriter(destinationFiles, /*dryRun=*/ false);
    process(writer, new DummyRevision("2"));

    Files.write(workdir.resolve("test.txt"), "three".getBytes());
    process(writer, new DummyRevision("3"));

    Reader<GitRevision> reader = destination.newReader(destinationFiles);
    reader.visitChanges(/*start=*/ null, ignore -> VisitResult.CONTINUE);

    Files.write(workdir.resolve("test.txt"), "four".getBytes());
    process(writer, new DummyRevision("4"));
  }