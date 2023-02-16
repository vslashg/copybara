/*
 * Copyright (C) 2023 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.copybara;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.copybara.action.Action;
import com.google.copybara.action.ActionContext;
import com.google.copybara.transform.SkylarkConsole;
import net.starlark.java.annot.StarlarkBuiltin;
import net.starlark.java.annot.StarlarkMethod;
import net.starlark.java.eval.Dict;
import net.starlark.java.eval.Sequence;
import net.starlark.java.eval.StarlarkList;

/** Skylark context for migrations that can do arbitrary endpoint calls and file manipulations. */
@SuppressWarnings("unused")
@StarlarkBuiltin(
    // TODO(b/269526710): Rename this. Update docs
    name = "feedback.context",
    doc =
        "Gives access to the feedback migration information and utilities. This context is a "
            + "concrete implementation for feedback migrations.")
public class ActionMigrationContext extends ActionContext<ActionMigrationContext> {

  private final ActionMigration actionMigration;
  private final ImmutableList<String> refs;

  ActionMigrationContext(
      ActionMigration actionMigration, Action currentAction,  ImmutableMap<String, String> labels,
      ImmutableList<String> refs, SkylarkConsole console) {
    this(actionMigration, currentAction, labels, refs, console, Dict.empty());
  }

  private ActionMigrationContext(
      ActionMigration actionMigration,
      Action currentAction,
      ImmutableMap<String, String> labels,
      ImmutableList<String> refs,
      SkylarkConsole console,
      Dict<?, ?> params) {
    super(currentAction, console, labels, params);
    this.actionMigration = Preconditions.checkNotNull(actionMigration);
    this.refs = ImmutableList.copyOf(refs);
  }

  @StarlarkMethod(name = "origin", doc = "An object representing the origin. Can be used to"
      + " query about the ref or modifying the origin state", structField = true)
  public Endpoint getOrigin() {
    return actionMigration.getTrigger().getEndpoint().withConsole(getConsole());
  }

  @StarlarkMethod(name = "destination", doc = "An object representing the destination. Can be used"
      + " to query or modify the destination state", structField = true)
  public Endpoint getDestination() {
    return actionMigration.getDestination().withConsole(getConsole());
  }

  // TODO(b/269526710): Deprecate this
  @StarlarkMethod(
      name = "feedback_name",
      doc = "DEPRECATED: The name of the Feedback migration calling this action."
          + " Use migration_name instead.",
      structField = true)
  public String getFeedbackName() {
    return actionMigration.getName();
  }

  @StarlarkMethod(
      name = "migration_name",
      doc = "The name of the migration calling this action.",
      // TODO(b/269526710): Set this to true
      documented = false,
      structField = true)
  public String getMigrationName() {
    return actionMigration.getName();
  }

  @StarlarkMethod(
      name = "refs",
      doc =
          "A list containing string representations of the entities " + "that triggered the event",
      structField = true)
  public Sequence<String> getRefs() {
    return StarlarkList.immutableCopyOf(refs);
  }

  @Override
  public ActionMigrationContext withParams(Dict<?, ?> params) {
    return new ActionMigrationContext(actionMigration, action, labels, refs, console, params);
  }
}