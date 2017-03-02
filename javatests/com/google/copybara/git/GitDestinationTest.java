import com.google.copybara.testing.DummyRevision;
  private void process(Destination.Writer writer, DummyRevision originRef)
  private void processWithBaseline(Destination.Writer writer, DummyRevision originRef,
      DummyRevision originRef,
        destinationFirstCommit().newWriter(destinationFiles, /*migrationIdentity=*/ null),
        new DummyRevision("origin_ref"));
    processWithBaselineAndConfirmation(
        destinationFirstCommit().newWriter(destinationFiles, /*migrationIdentity=*/ null),
        new DummyRevision("origin_ref"),
        /*baseline=*/ null, /*askForConfirmation=*/
        true);
        destinationFirstCommit().newWriter(destinationFiles, /*migrationIdentity=*/ null),
        new DummyRevision("origin_ref1"),
        /*baseline=*/ null, /*askForConfirmation=*/
        true);
        destination().newWriter(destinationFiles, /*migrationIdentity=*/ null),
        new DummyRevision("origin_ref2"),
        /*baseline=*/ null, /*askForConfirmation=*/
        true);
    processWithBaselineAndConfirmation(
        destinationFirstCommit().newWriter(destinationFiles, /*migrationIdentity=*/ null),
        new DummyRevision("origin_ref"),
        /*baseline=*/ null, /*askForConfirmation=*/
        true);
    DummyRevision ref = new DummyRevision("origin_ref");
    process(destinationFirstCommit().newWriter(destinationFiles, /*migrationIdentity=*/ null), ref);
    process(destination().newWriter(destinationFiles, /*migrationIdentity=*/ null), ref);
    process(
        destination().newWriter(destinationFiles, /*migrationIdentity=*/ null),
        new DummyRevision("origin_ref"));
    process(
        destination().newWriter(destinationFiles, /*migrationIdentity=*/ null),
        new DummyRevision("origin_ref"));
    process(
        destinationFirstCommit().newWriter(destinationFiles, /*migrationIdentity=*/ null),
        new DummyRevision("origin_ref"));
    process(
        destination().newWriter(destinationFiles, /*migrationIdentity=*/ null),
        new DummyRevision("origin_ref"));
    process(
        destination().newWriter(destinationFiles, /*migrationIdentity=*/ null),
        new DummyRevision("origin_ref"));
    DummyRevision ref1 = new DummyRevision("first");
    Writer writer1 = destinationFirstCommit().newWriter(firstGlob,
                                                         /*migrationIdentity=*/ null);
    DummyRevision ref2 = new DummyRevision("second");
    Writer writer2 = destination().newWriter(new Glob(ImmutableList.of("baz/**")),
                                              /*migrationIdentity=*/ null);
    assertThat(destination().newWriter(firstGlob, /*migrationIdentity=*/ null)
                   .getPreviousRef(ref1.getLabelName())).isEqualTo(
    Destination.Writer writer =
        destinationFirstCommit().newWriter(destinationFiles, /*migrationIdentity=*/ null);
    process(writer, new DummyRevision("first_commit"));
    writer = destination().newWriter(destinationFiles, /*migrationIdentity=*/ null);
    process(writer, new DummyRevision("second_commit"));
    writer = destination().newWriter(destinationFiles, /*migrationIdentity=*/ null);
    process(writer, new DummyRevision("third_commit"));
    process(
        destinationFirstCommit().newWriter(destinationFiles, /*migrationIdentity=*/ null),
        new DummyRevision("first_commit"));
    assertThat(
            destination()
                .newWriter(destinationFiles, /*migrationIdentity=*/ null)
                .getPreviousRef(DummyOrigin.LABEL_NAME))
    process(
        destinationFirstCommit().newWriter(destinationFiles, /*migrationIdentity=*/ null),
        new DummyRevision("first_commit"));
    destination()
        .newWriter(destinationFiles, /*migrationIdentity=*/ null)
        .getPreviousRef(DummyOrigin.LABEL_NAME);
    process(
        destinationFirstCommit().newWriter(destinationFiles, /*migrationIdentity=*/ null),
        new DummyRevision("first_commit").withTimestamp(Instant.ofEpochSecond(1414141414)));
    process(
        destination().newWriter(destinationFiles, /*migrationIdentity=*/ null),
        new DummyRevision("second_commit").withTimestamp(Instant.ofEpochSecond(1515151515)));
    process(
        destinationFirstCommit().newWriter(destinationFiles, /*migrationIdentity=*/ null),
        new DummyRevision("first_commit"));
    process(
        destinationFirstCommit().newWriter(destinationFiles, /*migrationIdentity=*/ null),
        new DummyRevision("first_commit").withTimestamp(Instant.ofEpochSecond(1414141414)));
    process(
        destination().newWriter(destinationFiles, /*migrationIdentity=*/ null),
        new DummyRevision("second_commit").withTimestamp(Instant.ofEpochSecond(1414141490)));
    process(
        destinationFirstCommit().newWriter(destinationFiles, /*migrationIdentity=*/ null),
        new DummyRevision("first_commit").withTimestamp(Instant.ofEpochSecond(1414141414)));
    process(
        destination().newWriter(destinationFiles, /*migrationIdentity=*/ null),
        new DummyRevision("second_commit").withTimestamp(Instant.ofEpochSecond(1414141490)));
    process(
        destinationFirstCommit().newWriter(destinationFiles, /*migrationIdentity=*/ null),
        new DummyRevision("first_commit"));
    process(
        destinationFirstCommit().newWriter(destinationFiles, /*migrationIdentity=*/ null),
        new DummyRevision("first_commit"));
    DummyRevision firstCommit = new DummyRevision("first_commit")
    process(
        destinationFirstCommit().newWriter(destinationFiles, /*migrationIdentity=*/ null),
        firstCommit);
    process(
        destination().newWriter(destinationFiles, /*migrationIdentity=*/ null),
        new DummyRevision("ref"));
    process(
        destination().newWriter(destinationFiles, /*migrationIdentity=*/ null),
        new DummyRevision("ref"));
    DummyRevision ref = new DummyRevision("origin_ref");
    process(destinationFirstCommit().newWriter(destinationFiles, /*migrationIdentity=*/ null), ref);
    process(destination().newWriter(destinationFiles, /*migrationIdentity=*/ null), ref);
    processWithBaseline(
        destination().newWriter(destinationFiles, /*migrationIdentity=*/ null), ref, firstCommit);
    DummyRevision ref = new DummyRevision("origin_ref");
    process(destinationFirstCommit().newWriter(destinationFiles, /*migrationIdentity=*/ null), ref);
    process(destination().newWriter(destinationFiles, /*migrationIdentity=*/ null), ref);
    processWithBaseline(
        destination().newWriter(destinationFiles, /*migrationIdentity=*/ null), ref, firstCommit);
    DummyRevision ref = new DummyRevision("origin_ref");
    process(destinationFirstCommit().newWriter(destinationFiles, /*migrationIdentity=*/ null), ref);
    process(destination().newWriter(destinationFiles, /*migrationIdentity=*/ null), ref);
    processWithBaseline(
        destination().newWriter(destinationFiles, /*migrationIdentity=*/ null), ref, firstCommit);
    Destination.Writer writer =
        destinationFirstCommit().newWriter(destinationFiles, /*migrationIdentity=*/ null);
        writer.write(TransformResults.of(workdir, new DummyRevision("ref1")), console);
    result = writer.write(TransformResults.of(workdir, new DummyRevision("ref2")), console);
    DummyRevision ref = new DummyRevision("origin_ref");
    process(destinationFirstCommit().newWriter(destinationFiles, /*migrationIdentity=*/ null), ref);
    DummyRevision ref = new DummyRevision("origin_ref");
    process(destination().newWriter(destinationFiles, /*migrationIdentity=*/ null), ref);
    DummyRevision ref1 = new DummyRevision("origin_ref1");
    DummyRevision ref2 = new DummyRevision("origin_ref2");
    process(
        destinationFirstCommit().newWriter(destinationFiles, /*migrationIdentity=*/ null), ref1);
    process(destination().newWriter(destinationFiles, /*migrationIdentity=*/ null), ref2);